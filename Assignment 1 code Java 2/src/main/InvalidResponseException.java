package main;

public class InvalidResponseException extends Exception {
    private String input;
    public InvalidResponseException(String message,String input){
        super(message);
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
