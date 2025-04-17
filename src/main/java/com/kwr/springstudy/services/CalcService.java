package com.kwr.springstudy.services;

import com.kwr.springstudy.results.calc.CalculateResult;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CalcService {
//    private static final String[] validOperators = {"plus", "minus", "multiply", "divide", "modulo", "power"};
    // 위 처럼하면 수정 가능
    private static final List<String> validOperators;
    // validOperators 더 이상 인자 추가나 변경이 불가

    static {
        List<String> operators = new ArrayList<>();
        operators.add("plus");
        operators.add("minus");
        operators.add("multiply");
        operators.add("divide");
        operators.add("modulo");
        operators.add("power");
        validOperators = Collections.unmodifiableList(operators);
    }


    private static boolean isDoubleParseable(String input) {
        return CalcService.isDoubleParseable(input, false);
    }

    private static boolean isDoubleParseable(String input, boolean allowsNaN) {
        try {
            double result = Double.parseDouble(input);
            if (Double.isNaN(result)) {
                return allowsNaN;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public Pair <CalculateResult, Double> calculate(String aStr, String bStr, String op) {
        // - 0으로 나눌 수 없다
        // - 올바른 숫자가 아니다.
        // - 올바른 연산자가 아니다.
        // - 계산 성공
        if (op == null || !CalcService.validOperators.contains(op)) {
            return Pair.of(CalculateResult.FAILURE_INVALID_OPERATOR, 0D);
        }
        if (aStr == null || bStr == null||
        !isDoubleParseable(aStr) ||
        !isDoubleParseable(bStr)) {
            return Pair.of(CalculateResult.FAILURE_INVALID_NUMBER, 0D);
        }

        double b = Double.parseDouble(bStr);

        if (b == 0 && op.equals("divide") || op.equals("modulo")) {
            return Pair.of(CalculateResult.FAILURE_DIVIDE_BY_ZERO, 0D);
        }
        double a = Double.parseDouble(aStr);
        double result = switch(op) {
            case "plus" -> a + b;
            case "minus" -> a - b;
            case "multiply" -> a * b;
            case "divide" -> a / b;
            case "modulo" -> a % b;
            case "power" -> Math.pow(a, b);
            default -> throw new UnsupportedOperationException();
        };
        return Pair.of(CalculateResult.SUCCESS, result);
    }
}

//pair, list