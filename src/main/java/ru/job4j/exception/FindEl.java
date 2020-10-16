package ru.job4j.exception;

public class FindEl {
    public static int indexOf(String[] array, String key) throws ElementNotFoundException {
        int result = - 1;
        for (int index = 0; index < array.length; index++) {
            if (array[index].equals(key)) {
                result = index;
                break;
            } else {
                throw new ElementNotFoundException("Element don't found");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] array = {"element1", "element2", "element3"};
        try {
            System.out.println(indexOf(array, "element1"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
