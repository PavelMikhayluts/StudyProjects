package myStringBuilder;

public class ReplaceCommand extends Command{
    String deletedString;
    int start,end;
    ReplaceCommand(MyStringBuilder myStringBuilder,String deletedString,int start,int end) {
        super(myStringBuilder);
        this.deletedString=deletedString;
        this.start=start;
        this.end=end;
    }

    @Override
    public void undo() {
        myStringBuilder.replace(start,end,deletedString);
    }
}
