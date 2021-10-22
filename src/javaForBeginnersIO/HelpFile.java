package javaForBeginnersIO;

/**
 * Демонстрация работы справочной системы на основе файла
 */

public class HelpFile {
    public static void main(String[] args) {
        // Передаем в конструктор путь к нашему файлу в виде строки
        Help helpObj=new Help("C:\\Users\\Admin\\Desktop\\HelpFile.txt");

        String topic;

        System.out.println("Воспользуйтесь справочной системой.\n"+
                "Для выхода из системы введите 'stop'.");
        do{
            topic=helpObj.getSelection();
            if (!helpObj.helpOn(topic)){
                System.out.println("Заголовок не найден. \n");
            }
        }while(topic.compareTo("stop")!=0);
    }
}
