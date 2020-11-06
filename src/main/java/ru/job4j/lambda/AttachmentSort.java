package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("element 2", 5),
                new Attachment("element 1", 10),
                new Attachment("element 3", 15)
        );

        Comparator comparatorByName = new Comparator<Attachment>() {

            @Override
            public int compare(Attachment first, Attachment second) {
                return first.getName().compareTo(second.getName());
            }
        };

        Comparator comparatorBySize = new Comparator<Attachment>() {

            @Override
            public int compare(Attachment first, Attachment second) {
                return Integer.compare(first.getSize(), second.getSize());
            }
        };
        attachments.sort(comparatorByName);
        System.out.println(attachments);
        attachments.sort(comparatorBySize);
        System.out.println(attachments);
    }
}
