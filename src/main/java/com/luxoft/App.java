package com.luxoft;

import com.luxoft.util.Utils;

import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.*;

public class App 
{
    public static void main( String[] args )
    {
        try {
            byte[] bytes = readAllBytes(Paths.get("Input.txt"));
            String content = new String(bytes);
            Utils.run(content);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
