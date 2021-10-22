package myStringBuilder;

public class Main {
    public static void main(String[] args) {
        MyStringBuilder myStringBuilder=new MyStringBuilder("Hello");
        myStringBuilder.append(" World.");
        System.out.println(myStringBuilder.toString());
        myStringBuilder.append(" Vasya.");
        System.out.println(myStringBuilder.toString());
        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());
        myStringBuilder.delete(6,12);
        System.out.println(myStringBuilder.toString());
        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());
        myStringBuilder.reverse();
        System.out.println(myStringBuilder.toString());
        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());
        myStringBuilder.replace(6,12,"Vasya");
        System.out.println(myStringBuilder.toString());
        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());
    }

}
