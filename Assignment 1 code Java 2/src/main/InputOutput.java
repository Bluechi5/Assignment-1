package main;

import java.nio.file.InvalidPathException;
import java.util.Scanner;

public class InputOutput {
    private File file;
    public String inputString(){
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public void dictionaryQuestion(){
        System.out.println("Hello, is there a dictionary already created? Or would you like to create a new one? (enter yes for making a new dictionary or no for using the already existing dictionary)");
    }
    public void printGreeting(){
        System.out.println("Hello, welcome to the corrector, please input the address for the corpus: ");
    }
    public void printDictionaryCreate(){
        System.out.println("\nDictionary created and saved.");
    }
    public void printErrorIPE(InvalidPathException IPE){
        System.out.println("\n"+IPE.getInput() + " is not a valid path. " + IPE.getMessage());
    }
    public void printErrorIRE(InvalidResponseException IRE){
        System.out.println("\n"+IRE.getInput() + " is not a valid input " + IRE.getMessage());
    }
    public void setFile(){

    }
    public File getFile() {
        return file;
    }
}
