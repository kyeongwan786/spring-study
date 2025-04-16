package com.kwr.springstudy.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/study")
public class StudyController {
    @RequestMapping(value = "/testOne", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public String getTestOne(@RequestParam(value = "a", required = false, defaultValue = "0") int a,
                             @RequestParam(value = "b", required = false, defaultValue = "0") int b) {
        System.out.println("a:" + a + ", b:" + b);
        return "{\"result\":a+b}";
    }

    // localhost:8080/study/calc
    @RequestMapping(value = "/calc", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String getCalc() {
        System.out.println("GET 방식 실행 됨");
        return "study/calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String postCalc(@RequestParam(value = "a") double a,
                           @RequestParam(value = "b") double b,
                           @RequestParam(value = "op") String op,
                           Model model) {
        System.out.println("post");
        Double result = null;
        if( op.equals("plus")) {
            result = a + b;
        }
        if( op.equals("minus")) {
            result = a - b;
        }
        if( op.equals("multiply")) {
            result = a * b;
        }
        if( op.equals("divide")) {
            result = a / b;
        }
        if( op.equals("modulo")) {
            result = a % b;
        }
        if( op.equals("power")) {
            result = Math.pow(a, b);
        }
        model.addAttribute("result", result);
        return "study/calc";
    }
}
