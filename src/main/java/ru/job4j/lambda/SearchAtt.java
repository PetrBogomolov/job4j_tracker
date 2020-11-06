package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        UnaryOperator<List<Attachment>> func = new UnaryOperator<List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> list) {
                List<Attachment> result = new ArrayList<>();
                for (Attachment att : list) {
                    if (att.getSize() > 100) {
                        result.add(att);
                    }
                }
                return result;
            }
        };
        return filter(list, func);
    }

   public static List<Attachment> filterName(List<Attachment> list) {
        UnaryOperator<List<Attachment>> func = new UnaryOperator<List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> list) {
                List<Attachment> result = new ArrayList<>();
                for(Attachment att : list) {
                    if (att.getName().contains("bug")) {
                        result.add(att);
                    }
                }
                return result;
            }
        };
        return filter(list, func);
   }

    private static List<Attachment> filter(List<Attachment> list, UnaryOperator<List<Attachment>> func) {
        return func.apply(list);
    }

   public static void main(String[] args) {
        List<Attachment> example = Arrays.asList(
                new Attachment("ug", 101),
                new Attachment("bug", 99),
                new Attachment("bu", 94),
                new Attachment("bug", 192),
                new Attachment("bg", 120)
        );
        System.out.println(filterSize(example));
        System.out.println(filterName(example));
   }
}
