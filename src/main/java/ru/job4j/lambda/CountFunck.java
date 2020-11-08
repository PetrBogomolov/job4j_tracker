package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountFunck {

    public List<Double> createLinearFunc(int start, int end) {
        Function<Double, Double> func = doub -> (2 * doub + 1);
        return diapason(start, end, func);
    }

    public List<Double> createSquareFunc(int start, int end) {
        Function<Double, Double> func = doub -> (doub * doub);
        return diapason(start, end, func);
    }

    public List<Double> createExponentialFunc(int start, int end) {
        Function<Double, Double> func = doub -> Math.pow(doub, doub);
        return diapason(start, end, func);
    }

    private static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        double x, y;
        for (int i = start; i < end; i++) {
            x = i;
            y = func.apply(x);
            result.add(y);
        }
        return result;
    }
}
