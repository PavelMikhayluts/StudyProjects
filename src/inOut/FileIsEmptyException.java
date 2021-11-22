package inOut;

public class FileIsEmptyException extends Exception {

    public FileIsEmptyException(String message){
        super(message);
        System.out.println(message + " пуст.");
    }
}
