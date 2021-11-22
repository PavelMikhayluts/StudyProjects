package collections.zadanie;

import collections.hashMap.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Vocabulary {

    private TreeMap<Character,Integer> map = new TreeMap<>();
    private Integer value = 0;

    public static void main(String[] args) {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.makeVocabulary();
        vocabulary.showVocabulary();
    }

    private void makeVocabulary() {
        try {
            Scanner in = new Scanner(new FileInputStream("C:\\Users\\Admin\\Desktop\\Тест коллекций.txt"));
            while (in.hasNext()) {
                String word = in.next();
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char key = chars[i];
                    Integer value = map.get(key);
                    if (null != value) {
                        value++;
                        map.replace(key, value);
                    } else {
                        value = 1;
                        map.put( key, value );
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void showVocabulary() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Символ <" + entry.getKey() + "> встречается " + entry.getValue() + " раз.");
        }
    }
}





