package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String str;
        String[] strings = new String[4];
        int count = 0;
        try (BufferedReader fr = new BufferedReader(new java.io.FileReader(file))) {
            while ((str = fr.readLine()) != null) {
                String[] temp = str.split(" ");
                strings[count]= temp[1];
                count++;
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return new Profile(strings[0],Integer.parseInt(strings[1]),strings[2],Long.decode(strings[3]));
    }
}
