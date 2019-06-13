package main;

public class Menu {
    private InputOutput inputOutput;
    private Dictionary dictionary;
    private InvalidResponseException IRE = null;
    Menu(InputOutput inputOutput){
        this.inputOutput = inputOutput;
    }
    public void createOrLoad(){
        var temp = "";
        inputOutput.dictionaryQuestion();
        try{
            temp = inputOutput.inputString();
            if(temp.matches("^(((y|Y)(e|E)(s|S))|((n|N)(o|O)))")){
                this.IRE = null;
            }
            else{
                throw new InvalidResponseException("\nInput given is wrong. Try again.", temp);
            }
        }
        catch(InvalidResponseException IRE){
            this.IRE = IRE;
            inputOutput.printErrorIRE(IRE);
        }
        finally{
            if(IRE == null){
                if(temp.matches("^((y|Y)(e|E)(s|S))")){
                    inputOutput.printGreeting();
                    inputOutput.inputCorpusPath();
                    this.dictionary = new Dictionary(inputOutput,inputOutput.getCorpusLocalFile());
                    dictionary.createDictionary();
                }
            }
            else{
                createOrLoad();
            }
        }
    }
}