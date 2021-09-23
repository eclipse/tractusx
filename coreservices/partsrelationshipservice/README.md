# Parts Relationship Service

## How to run

The two following subsections provide instructions for running either only the infrastructure on docker-compose and the application in the IDE, or for running the full stack (including the application) in docker-compose.

### Docker-compose + IDE

* Start the necessary infrastructure by running `docker-compose up`

* Start the application from your favorite IDE

### Docker-compose full stack

* (Optional) Copy the file `.env.example` to `.env` and provide your Application Insights connection string.

* Run `docker-compose --profile prs up`

## Work with sample data

* Retrieve one sample preloaded BOM:

```bash
curl -X GET "http://localhost:8080/api/v0.1/vins/BMWOVCDI21L5DYEUU/partsTree?view=AS_BUILT"
```

## Inspect data

### Get persisted data

```bash
docker exec -it db bash -c 'psql -U $POSTGRES_USER postgres'
```

```sql
select * from part_relationship;
```

## Swagger UI

- Swagger UI: http://localhost:8080/swagger-ui
- API docs: http://localhost:8080/api-docs
- API docs in yaml:  http://localhost:8080/api-docs.yaml

## Terraform

See [Terraform deployment](terraform).

## Deploy PRS

The new version of the application is deployed on merge to main through the `Deploy PRS` workflow.
The workflow builds a new image, pushes it to ACR and deploys it to Kubernetes. If you make changes to Terraform, these changes will be applied as the workflow runs `terraform apply`.
If you want to make sure the PRS deployment will work well with your changes, you can run the `Deploy PRS` workflow manually on your branch. Note that other PRs merged to main will cause Terraform to potentially roll back those changes.