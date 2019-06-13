package main;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Dictionary{
    private InputOutput inputOutput;
    private LocalFile dictionaryFile;
    private LocalFile corpusLocalFile;
    private ArrayList<Word> words = new ArrayList<>();
    Dictionary(InputOutput inputOutput, LocalFile corpusLocalFile){
        this.inputOutput = inputOutput;
        this.corpusLocalFile = corpusLocalFile;
    }
    public void createDictionary(){
        this.dictionaryFile = new LocalFile("dictionary.txt",this.inputOutput);
        try(var br = Files.newBufferedReader(corpusLocalFile.getPath());
            var bw = Files.newBufferedWriter(dictionaryFile.getPath())) {
            String line;
            var wordFound = false;
            while((line = br.readLine()) != null){
                for(var word: words) {
                    if (word.getWord().equals(line)) {
                        word.setFrequency(word.getFrequency() + 1);
                        wordFound = true;
                        break;
                    }
                }
                if(!wordFound){
                    var word = new Word(line, 1);
                    words.add(word);
                }
            }
            for(var word: words){
                bw.write(word.getWord()+ " " + word.getFrequency());
                bw.newLine();
            }
        }
        catch(IOException IOX){

        }
    }
}