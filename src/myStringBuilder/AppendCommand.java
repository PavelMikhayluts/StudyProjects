package myStringBuilder;

public class AppendCommand extends Command{

    AppendCommand(MyStringBuilder myStringBuilder) {
        super(myStringBuilder);
    }

    public void undo(){
        myStringBuilder.currentLength=myStringBuilder.length();
        myStringBuilder.sb.delete(myStringBuilder.beforeLength,myStringBuilder.currentLength);
    }
}
