package collections.HashSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * В данной программе выводятся все слова,
 * введенные из потока System.in во множество
 * @version 1.1 2021/11/09
 * @author Mikhailuts Pavel
 */

public class SetTest {
    public static void main(String[] args) {

        Set<String> words = new HashSet<>();
        long totalTime = 0;

        try {
            Scanner in = new Scanner(new FileInputStream("C:\\Users\\Admin\\Desktop\\Тест коллекций.txt"));
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Iterator<String> iter = words.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("Количество слов: " + words.size() + ", время отклика коллекции: " + totalTime);
    }


}
