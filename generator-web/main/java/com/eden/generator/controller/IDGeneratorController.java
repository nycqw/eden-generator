package com.eden.generator.controller;

import com.eden.generator.service.IDGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenqw
 * @since 2019/3/14
 */
@Controller
@Slf4j
public class IDGeneratorController {

    @Autowired
    private IDGeneratorService idGeneratorService;

    @GetMapping("/id/next")
    @ResponseBody
    public String next(@RequestParam String bizCode) {
        String serialCode = idGeneratorService.next(bizCode);
        log.info("serial code -> {}", serialCode);
        return serialCode;
    }
}
