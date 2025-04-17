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
    public String postCalc(@RequestParam(value = "a") String astr,
                           @RequestParam(value = "b") String bstr,
                           @RequestParam(value = "op") String op,
                           Model model) {
        System.out.println("post");
        Double a = null;
        Double b = null;
        String error = null;

        try {
            a = Double.parseDouble(astr);
            b = Double.parseDouble(bstr);
        } catch (NumberFormatException ignored) {
            error = "올바른 숫자가 아닙니다.";
        }
        if (error == null) {
            if ((op.equals("divide") || op.equals("modulo")) && b == 0D) {
                error = "0으로 나눌 수 없습니다.";
            } else {
                Double result = null;
                String opSc = null;
                switch (op) {
                    case "plus":
                        result = a + b;
                        opSc = "+";
                        break;
                    case "minus":
                        result = a - b;
                        opSc = "-";
                        break;
                    case "divide":
                        result = a / b;
                        opSc = "/";
                        break;
                    case "modulo":
                        result = a % b;
                        opSc = "%";
                        break;
                    case "multiply":
                        result = a * b;
                        opSc = "*";
                        break;
                    case "pow":
                        result = Math.pow(a, b);
                        opSc = "**";
                        break;
                }
                model.addAttribute("a", a); // 연산식을 표현하기 위해 필요
                model.addAttribute("b", b); // 연산식을 표현하기 위해 필요
                model.addAttribute("opSc", opSc); // 연산식을 표현하기 위해 필요
                model.addAttribute("op", op); // select 태그의 초기 선택될 option 태그에 selected 속성을 부여하기 위해 필요
                model.addAttribute("result", result); // 결과값 전달
            }

        }

        model.addAttribute("error", error);
        return "study/calc";
    }
}

//Double result = switch (op) {
//    case "plus" -> a + b;
//    case "minus" -> a - b;
//    case "multiply" -> a + b;
//    case "plus" -> a + b;
//    case "plus" -> a + b;
//    default -> null;
//} switch 표현식
