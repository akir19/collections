package Lesson_3.Collection;

import java.util.*;

public class MyArray {

    private List<String> arrayList;

    public MyArray(String[] words) {
        arrayList = Arrays.asList(words);
    }

    private String getFrequencyRepeat() {
        String[] unique = getUniqueWords();
        String arr = "";
        int num;
        for (int i = 0; i < unique.length; i++) {
            num = Collections.frequency(arrayList, unique[i]);
            arr += "(" + unique[i] + ", " + num + ") ";
        }
        return arr;
    }

    private String[] getUniqueWords() {
        HashSet<String> arr = new HashSet<>();
        for (String str : arrayList) {
            arr.add(str);
        }
        return arr.toArray(new String[arr.size()]);
    }

    private String[] getAllWords() {
        return arrayList.toArray(new String[arrayList.size()]);
    }

    private void printStrings(String[] arr) {
        String str = "";
        for (String s : arr) {
            str.concat(s);
            str.concat(" ");
        }
        System.out.println(str);
    }

    public static void main(String[] args) {

        String[] uefa2016 = new String[]{"AUT", "ALB", "BEL", "ENG", "BEL", "HUN", "GER",
                                         "IRL", "ISL", "ESP", "ITA", "BEL", "HUN"};

        MyArray myArray = new MyArray(uefa2016);

        System.out.println("Всего элементов в массиве : " + myArray.getAllWords().length);
        myArray.printStrings(myArray.getAllWords());

        System.out.println("\nУникальных элементов в массиве : " + myArray.getUniqueWords().length);
        myArray.printStrings(myArray.getUniqueWords());

        System.out.println("\nВсе слова с числом повторений :");
        System.out.println((myArray.getFrequencyRepeat()));
    }
}

