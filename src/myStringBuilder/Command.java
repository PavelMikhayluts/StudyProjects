package myStringBuilder;

public abstract class Command {

    public Command(MyStringBuilder myStringBuilder, String deletedString, int start){}

    public Command(MyStringBuilder myStringBuilder, int beforeLength) {}

    public Command(MyStringBuilder myStringBuilder, int beforeLength, int currentLength) {}

    public Command(MyStringBuilder myStringBuilder, String deletedString, int start, int newEnd) {}

    public Command(MyStringBuilder myStringBuilder) {}

    public abstract void undo();
}
