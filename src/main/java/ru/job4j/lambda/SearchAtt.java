package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment att : list) {
            Predicate<Attachment> func = attachment -> att.getSize() > 100;
            if (filter(att, func)) {
                result.add(att);
            }
        }
        return result;
    }

   public static List<Attachment> filterName(List<Attachment> list) {
       List<Attachment> result = new ArrayList<>();
       for (Attachment att : list) {
           Predicate<Attachment> func = attachment -> att.getName().contains("bug");
           if (filter(att, func)) {
               result.add(att);
           }
       }
       return result;
   }

    private static boolean filter(Attachment attachment, Predicate<Attachment> func) {
        return func.test(attachment);
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
