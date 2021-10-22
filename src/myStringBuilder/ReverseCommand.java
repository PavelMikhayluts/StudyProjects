package myStringBuilder;

public class ReverseCommand extends Command{
    ReverseCommand(MyStringBuilder myStringBuilder) {
        super(myStringBuilder);
    }

    public void undo() {
        myStringBuilder.reverse();
    }
}
