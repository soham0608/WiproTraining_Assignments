package com.wipro.logdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/greet")
    public String greet() {
        logger.error("--Error--");
        logger.warn("--WARN--");
        logger.info("--INFO--");
        logger.debug("--DEBUG--");
        logger.trace("--TRACE--");

        return "Hello! Check your logs to see which log levels are printed.";
    }
}

