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
    private StringBuilder sb;

    MyStringBuilder(String str) {
       sb = new StringBuilder(str);
   }


    public StringBuilder append(String str) {
       int beforeLength = sb.length();
       sb.append(str);
       int currentLength = sb.length() ;
       executeCommand( new Command(this, beforeLength+1, currentLength) {
            public void undo() {
                sb.delete(beforeLength, currentLength);
            }
       });
       return sb;
    }

    public StringBuilder delete(int start, int end) {
        String deletedString = sb.substring(start, end);
        sb.delete(start, end);
        executeCommand(new Command(this, deletedString, start){
            public void undo() {
                sb.insert(start, deletedString);
            }
        });
        return sb;
    }

    public StringBuilder reverse(){
       sb.reverse();
       executeCommand(new Command(this){
           public void undo() {
               sb.reverse();
           }
       });
       return sb;
    }

    public StringBuilder replace(int start, int end, String str) {
        int newEnd = start + str.length(); //Конечный индекс обрезки для отмены replace
        String deletedString = sb.substring(start, end);
        executeCommand(new Command(this, deletedString, start, newEnd){
            public void undo() {
                sb.replace(start, end, deletedString);
            }
        });
        sb.replace(start, end, str);
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

