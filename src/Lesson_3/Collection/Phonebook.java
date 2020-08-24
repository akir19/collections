package Lesson_3.Collection;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {

    private HashMap<String, HashSet<String>> record;

    public Phonebook() {
        record = new HashMap<>();
    }

    private void add(String name, String... phone) {                       //Если в массиве нет добавляемой фамилии,
        HashSet<String> ph = new HashSet<>();                              //то добавляет фамилию и ее телефоны.
        for (String s : phone) {                                           //   Если такая фамилия уже есть в массиве, то 1) достает ее оттуда,
            ph.add(s);                                                     //   2) берет из нее телефоны, 3) добавляет новые телефоны к старым
        }                                                                  //   4) записывает в массив поверх старой фамилии ее же, но с новой толпой телефонов (старые+новые)
        if (!record.containsKey(name))                                     // Уникальность телефонов в каждой фамилии обеспечивается через HashSet
            record.put(name, ph);                                          // Уникальность Фамилии в масииве (ключевого поля) обеспечивается при добавлении новой записи
        else {
            HashSet<String> phAdd = new HashSet<>();
            String[] s2 = record.get(name).toArray(new String[phAdd.size()]);
            for (String s : s2) {
                ph.add(s);
            }
            record.replace(name, ph);
        }
    }

    private String get(String name) {
        String phones = "Такого абонента нет в телефонной книге";
        if (record.containsKey(name)) {
            phones = record.get(name).toString();
        }
        return phones;
    }

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "89063213233");                     //Иванов 1 - будет добавлен
        phonebook.add("Петров", "89063213234");
        phonebook.add("Сидоров", "89063213235");
        phonebook.add("Васильев", "89063213236");
        phonebook.add("Смирнов", "89063213237", "89163213007");
        phonebook.add("Иванов", "89063213238");                     //Иванов 2 - будут добавлены только телефоны к телефонам в Иванове 1
        phonebook.add("Краснова", "89063213239");
        phonebook.add("Иванов", "89063213238");                     //Иванов 3 - не будет добавлен вообще, т.к. такой телефон уже есть в Иванове 2

        System.out.println("Смирнов : " + phonebook.get("Смирнов"));
        System.out.println("Иванов : " + phonebook.get("Иванов"));
        System.out.println("Сидоров : " + phonebook.get("Сидоров"));
        System.out.println("Чичиков : " + phonebook.get("Чичиков"));
    }
}
