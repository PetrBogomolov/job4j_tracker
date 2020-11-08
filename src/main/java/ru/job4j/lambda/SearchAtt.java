package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> func = att -> att.getSize() > 100;
        return filter(list, func);
    }

   public static List<Attachment> filterName(List<Attachment> list) {
       Predicate<Attachment> func = attachment -> attachment.getName().contains("bug");
       return filter(list, func);
   }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> func) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment att : list) {
            if (func.test(att)) {
                result.add(att);
            }
        }
        return result;
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
