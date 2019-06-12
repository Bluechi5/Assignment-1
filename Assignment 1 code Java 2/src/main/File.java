package main;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {
    private Path path;
    private String name;
    private InputOutput inputOutput;
    File(String path, InputOutput inputOutput){
        this.inputOutput = inputOutput;
        try{
            this.path = Paths.get(path);
        }
        catch(InvalidPathException IPE){
            inputOutput.printErrorIPE(IPE);
        }
    }

    public void setPath(String path) {
        try {
            this.path = Paths.get(path);
        } catch (InvalidPathException IPE) {
            inputOutput.printErrorIPE(IPE);
        }
    }
}
