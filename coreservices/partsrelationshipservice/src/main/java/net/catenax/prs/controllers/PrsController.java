//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Application REST controller.
 */
@Tag(name = "Sample API")
@Slf4j
@RestController
public class PrsController {

    /**
     * Salutatory operation.
     * @return a fixed string.
     */
    @GetMapping("api/hello")
    public String hello() {
        return "Hello World!";
    }

}
