package myStringBuilder;

/**
 * ����� ���� StringBuilder �������������� ��� �� �������� undo, ���������� ������ ���������� ������ ������
 *
 * 23.10.2021
 *
 * �������� ����� ����������
 */

public class MyStringBuilder {

    private CommandHistory history = new CommandHistory();//������� ���� ��� �������� ��������
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
        int newEnd = start + str.length(); //�������� ������ ������� ��� ������ replace
        String deletedString = sb.substring(start, end);
        executeCommand(new Command(this, deletedString, start, newEnd){
            public void undo() {
                sb.replace(start, end, deletedString);
            }
        });
        sb.replace(start, end, str);
        return sb;
    }
   //����� executeCommand �������� ������ �� ������ ������� � �������� �� � ����
   private void executeCommand(Command command) {
       history.push(command);
    }

    // ����� undo() ��������� ��������� ������� �� ����� � �������� ����� undo �� ������� ��������� �������
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

