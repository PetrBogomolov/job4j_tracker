package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> storage = new LinkedHashSet<>();
        for (String string : deps) {
           String[] sections = string.split("/");
           StringBuilder department = new StringBuilder();
           for (String element : sections) {
               department.append(element);
               storage.add(department.toString());
               if (Arrays.asList(sections).indexOf(element) + 1 < sections.length) {
                   department.append("/");
               }
           }
        }
        return new ArrayList<>(storage);
    }

    public static void sortAscending(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDescending(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
