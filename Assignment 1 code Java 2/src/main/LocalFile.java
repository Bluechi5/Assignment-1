package main;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalFile {
    private Path path;
    private String name;
    private InputOutput inputOutput;
    LocalFile(String path, InputOutput inputOutput){
        this.inputOutput = inputOutput;
        try{
            this.path = Paths.get(path);
        }
        catch(InvalidPathException IPE){
            inputOutput.printErrorIPE(IPE);
        }
        finally{
            this.name = this.path.getFileName().toString();
        }
    }
    LocalFile(Path path){
        this.path = path;
        this.name = this.path.getFileName().toString();
    }

    public void setPath(String path) {
        try {
            this.path = Paths.get(path);
        } catch (InvalidPathException IPE) {
            inputOutput.printErrorIPE(IPE);
        }
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}