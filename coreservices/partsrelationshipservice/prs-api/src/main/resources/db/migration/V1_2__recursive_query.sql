CREATE OR REPLACE FUNCTION get_parts_tree(
    root_oneidmanufacturer text,
    root_objectidmanufacturer text,
    max_depth integer)
RETURNS SETOF part_relationship
LANGUAGE SQL AS $$
WITH RECURSIVE r(
    edge,
    parent_oneidmanufacturer,
    parent_objectidmanufacturer,
    oneidmanufacturer,
    objectidmanufacturer,
    depth,
    path
) AS (
    -- ROOT node query
    SELECT edge,
        parent_oneidmanufacturer,
        parent_objectidmanufacturer,
        oneidmanufacturer,
        objectidmanufacturer,
        1 AS depth,
        ARRAY [(parent_oneidmanufacturer,parent_objectidmanufacturer)] AS path
    FROM part_relationship edge
    WHERE parent_oneidmanufacturer = root_oneidmanufacturer
        AND parent_objectidmanufacturer = root_objectidmanufacturer
    UNION ALL
    -- recursive clause
    SELECT e AS edge,
        r.parent_oneidmanufacturer,
        r.parent_objectidmanufacturer,
        e.oneidmanufacturer,
        e.objectidmanufacturer,
        r.depth + 1 AS depth,
        r.path || (r.oneidmanufacturer, r.objectidmanufacturer) AS path
    FROM part_relationship AS e,
        r
    WHERE e.parent_oneidmanufacturer = r.oneidmanufacturer
        and e.parent_objectidmanufacturer = r.objectidmanufacturer
        AND (
            (
                e.parent_oneidmanufacturer,
                e.parent_objectidmanufacturer
            ) <> ALL(r.path) -- avoid cycles
        )
        and depth<max_depth
)
SELECT (r.edge).*
FROM r
$$;
