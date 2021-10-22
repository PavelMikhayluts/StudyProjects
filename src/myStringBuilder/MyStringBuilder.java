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
    public String myString;// ������, ������� �� ���������/�������� � ������������ ������
    public StringBuilder sb;
    static int beforeLength;//������� ����� ������ �� ���������
    static int currentLength;//������� ����� ������
    MyStringBuilder myStringBuilder=this;

    int start,end;
    int newEnd;
    String stringBeforeDelete;// ������ �� ������� ������
    String deletedString;// ������ �� ��������� ������
    char[]fullStringArray;// ������ �������� ��� ������� ������
    char[]deletedStringArray;// ������ �������� ��� ���������� �������

    //������� ������ MyStringBuilder, �������� ��� ����������� ������,������ �������������� �������� ������ ������
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
       stringBeforeDelete=sb.toString();//������� ������ �� ������ StringBuilder
        fullStringArray=stringBeforeDelete.toCharArray();//���������� ������� ������ � ������ ��������
       deletedStringArray=new char[end-start];// ������� ������ �������� ��� �������� ���������� �������
       for(int i=0,j=start;i<=((end-start)-1);i++,j++){//��������� ��������� ������� � ������
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
        newEnd=start+myString.length();//�������� ������ ������� ��� ������ replace
        char[]deletedStringArray=new char[(end-start)+1];//������ �������� ��� ���������� ������� ������
        stringBeforeDelete=sb.toString();//������� StringBuilder ���������� � ������
        char[]fullStringArray=stringBeforeDelete.toCharArray();//������ ���������� � ������ ��������
        for(int i=0, j=start-1;j<=fullStringArray.length-1;i++,j++){//��������� ����� ���� ������ ��������
            deletedStringArray[i]=fullStringArray[j];               //��� ���������� ���������� �������
        }
        deletedString=new String(deletedStringArray);//���������� ���������� ������� � ReplaceCommand
        executeCommand(new ReplaceCommand(myStringBuilder,deletedString,start,newEnd));
        sb.replace(start, end, myString);
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

