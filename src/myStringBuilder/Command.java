package myStringBuilder;

public abstract class Command {

    public MyStringBuilder myStringBuilder;

     Command(MyStringBuilder myStringBuilder){
         this.myStringBuilder=myStringBuilder;
     }

     public abstract void undo();


}
