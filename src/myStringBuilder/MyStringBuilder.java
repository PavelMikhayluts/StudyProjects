package myStringBuilder;

/**
 * Класс типа StringBuilder поддерживающий так же операцию undo, отменяющую эффект последнего вызова метода
 *
 * 23.10.2021
 *
 * Михайлуц Павел Николаевич
 */

public class MyStringBuilder {
    private CommandHistory history = new CommandHistory();//Создаем стек для обьектов комманда
    public String myString;// Строка, которую мы добавляем/убавляем к существующей строке
    public StringBuilder sb;
    static int beforeLength;//Счетчик длины строки до изменений
    static int currentLength;//Текущая длина строки
    MyStringBuilder myStringBuilder=this;

    int start,end;
    int newEnd;
    String stringBeforeDelete;// ссылка на текущую строку
    String deletedString;// ссылка на удаляемую строку
    char[]fullStringArray;// массив символов для текущей строки
    char[]deletedStringArray;// массив символов для удаляемого отрезка

    //Создаем обьект MyStringBuilder, передаем ему изначальную строку,задаем первоначальное значение длинны строки
   public MyStringBuilder(String str){
       myString=str;
       sb=new StringBuilder(myString);
       beforeLength=myStringBuilder.length();

   }

    public StringBuilder append(String str) {
       myString=str;
       sb.append(myString);
        if (history.isEmpty()==false) {
            beforeLength += myString.length();
        }
       executeCommand(new AppendCommand(myStringBuilder));
       return sb;
    }

    public StringBuilder delete(int start,int end) {
       this.start=start;
       this.end=end;
       stringBeforeDelete=sb.toString();//Создаем строку на основе StringBuilder
        fullStringArray=stringBeforeDelete.toCharArray();//превращаем текущую строку в массив символов
       deletedStringArray=new char[end-start];// создаем массив символов для хранения удаленного отрезка
       for(int i=0,j=start;i<=((end-start)-1);i++,j++){//переносим удаляемые символы в массив
           deletedStringArray[i]=fullStringArray[j];
       }
       deletedString=new String(deletedStringArray); //
       sb.delete(start, end);
       executeCommand(new DeleteCommand(myStringBuilder,deletedString));
       return sb;
    }

    public StringBuilder reverse(){
       sb.reverse();
        executeCommand(new ReverseCommand(myStringBuilder));
       return sb;
    }

    public StringBuilder replace(int start, int end, String str) {
        myString=str;
        this.start=start;
        this.end=end;
        newEnd=start+myString.length();//Конечный индекс обрезки для отмены replace
        char[]deletedStringArray=new char[(end-start)+1];//массив символов для вырезаного участка строки
        stringBeforeDelete=sb.toString();//текущий StringBuilder превращаем в строку
        char[]fullStringArray=stringBeforeDelete.toCharArray();//строку превращаем в массив символов
        for(int i=0, j=start-1;j<=fullStringArray.length-1;i++,j++){//заполняем через цикл массив символов
            deletedStringArray[i]=fullStringArray[j];               //для сохранения вырезаного участка
        }
        deletedString=new String(deletedStringArray);//отправляем выерезаный участок в ReplaceCommand
        executeCommand(new ReplaceCommand(myStringBuilder,deletedString,start,newEnd));
        sb.replace(start, end, myString);
        return sb;
    }
   //Метод executeCommand получает ссылку на обьект команды и помещает ее в стек
   private void executeCommand(Command command) {
       history.push(command);
    }

    // Метод undo() извлекает последнюю команду из стека и вызывает метод undo из обьекта последней команды
    public void undo() {
        if (history.isEmpty()) return;
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }



    public int length(){
       return sb.length();
    }
    public String toString(){
       return sb.toString();
   }
}

