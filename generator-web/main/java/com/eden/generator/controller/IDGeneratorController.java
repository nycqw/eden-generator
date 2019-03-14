package com.eden.generator.controller;

import com.eden.generator.service.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenqw
 * @since 2019/3/14
 */
@Controller
@EnableSwagger2
public class IDGeneratorController {

    @Autowired
    private IDGeneratorService idGeneratorService;

    @GetMapping("/id/next")
    @ResponseBody
    public String next(@RequestParam String bizCode) {
        return idGeneratorService.next(bizCode);
    }
}
