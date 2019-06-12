package main;

public class Dictionary{
    private InputOutput inputOutput;
    private File file;
    Dictionary(InputOutput inputOutput,File file){
        this.inputOutput = inputOutput;
        this.file = file;
    }
    public void createDictionary(){
        inputOutput.printGreeting();
    }
}
