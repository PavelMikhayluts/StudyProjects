package myStringBuilder;

public class DeleteCommand extends Command{
    String deletedString;
    DeleteCommand(MyStringBuilder myStringBuilder,String deletedString) {
        super(myStringBuilder);
        this.deletedString=deletedString;
    }

    @Override
    public void undo() {
        myStringBuilder.sb.append(deletedString);



    }
}
