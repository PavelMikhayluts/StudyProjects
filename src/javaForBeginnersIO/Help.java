package javaForBeginnersIO;
import java.io.*;

/**
 * Справочная система, использующая дисковый файл для хранения информации.
 * В классе Help открывается файл со справочной информацией,производится поиск указанной темы,
 * а затем отображается справочная информация.
*/

public class Help {
    String helpFile; // Имя справочного файла

    Help(String fname){ //Наличие конструктора дает нам возможность создавать отдельные наборы справочных файлов
        helpFile=fname;} // на разные темы.

    //Отобразить справочную информацию по указанной теме.
    boolean helpOn(String what){
        int ch;
        String topic,info;

        //Открыть справочный файл
        try (BufferedReader helpRdr=new BufferedReader(new FileReader(helpFile))){
            do{
                //Читать символы в файле до тех пор пока не встретится символ #
                ch=helpRdr.read();
                // проверить совпадают ли заголовки статей
                if(ch=='#'){
                    topic=helpRdr.readLine();
                       if (what.compareTo(topic)==0) {//Найти нужную тему по заголовку
                           do {
                               info = helpRdr.readLine();
                               if (info!= null) {
                                   System.out.println(info);
                               }
                           } while ((info != null) && (info.compareTo("")!= 0));
                           return true;

                    }
                }
            }while (ch!=-1);
        }catch (IOException exc){
            System.out.println("Ошибка при доступе к файлу справки.");
            return false;
        }
            return false; // нужный заголовко не найден.

    }

    //Получить тему справки от пользователя
    String getSelection(){
        String topic="";
        BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Укажите тему: ");
        try {
            topic= br.readLine();
        }catch(IOException exc){
            System.out.println("Ошибка при чтении с консоли");
        }
        return topic;
    }




}
