package org.sanskar;
import java.io.*;

public class FileIO {

    public void appendToFile(String filename, String content) throws IOException {
        try(FileWriter writer = new FileWriter(filename, true)){
            writer.write(content + System.lineSeparator());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
