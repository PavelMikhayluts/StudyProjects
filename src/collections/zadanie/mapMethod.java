package collections.zadanie;

import collections.hashMap.Employee;

import java.util.*;

/**
 * Напишите метод, который получает на вход Map<K, V>
 * и возвращает Map, где ключи и значения поменяны местами.
 */

public class mapMethod {

    public static void main(String[] args) {
        // Создаем HashMap и заполняем ее
        Map<String, Employee> staff = new HashMap<>();

        Map<Employee, List<String>> invertedStaff = new HashMap<>();//

        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Amy Lee"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));


        //Меняем местами ключи и значения
        for(Map.Entry<String, Employee> item : staff.entrySet()) {
            if (invertedStaff.containsKey(item.getValue())) {
                List<String> list = invertedStaff.get(item.getValue());
                list.add(item.getKey());
               // invertedStaff.replace(item.getValue(), list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(item.getKey());
                invertedStaff.put(item.getValue(), list);
            }
        }
        for(Map.Entry<Employee, List<String>> item1 : invertedStaff.entrySet()) {
            System.out.println(item1.getKey().getName() + " : " + item1.getValue());
        }
    }
}
