package com.example.demo;

import org.apache.maven.surefire.report.ReporterManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.maven.surefire.report.Reporter;

@RestController
public class SampleController {

    @GetMapping("/sample/test")
    public String test(){
        String msg = "OK";
        return msg;
    }
}
