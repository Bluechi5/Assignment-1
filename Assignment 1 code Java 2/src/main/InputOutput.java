package main;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputOutput {
    private LocalFile localFile;
    private LocalFile corpusLocalFile;
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
    public void printErrorIOE(IOException IOE){
        System.out.println("\n"+IOE.getMessage());
    }
    public void inputCorpusPath(){
        Path temp = null;
        var IPECaught = false;
        var scanner = new Scanner(System.in);
        try{
            temp = Paths.get(scanner.nextLine());
        }
        catch(InvalidPathException IPE){
            printErrorIPE(IPE);
            IPECaught = true;
        }
        finally{
            if (!IPECaught) {
                    setCorpusLocalFile(new LocalFile(temp));
            }
            else{
                temp = null;
                IPECaught = false;
                scanner = new Scanner(System.in);
                inputCorpusPath();
            }
        }
    }

    public void setCorpusLocalFile(LocalFile corpusLocalFile) {
        this.corpusLocalFile = corpusLocalFile;
    }

    public LocalFile getCorpusLocalFile() {
        return corpusLocalFile;
    }

    public void setLocalFile(LocalFile localFile){
        this.localFile = localFile;
    }
    public LocalFile getLocalFile() {
        return localFile;
    }
}