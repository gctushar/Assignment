/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gautam
 */
public class Exercise2 {
    
    //This method take a file as output as key value pair and sumUp the key and save on a file 
    private void SumUpKey(String inputFilePath, String outputFilePath) {

        File inputFile = null;
        FileReader inputFileReader = null;
        BufferedReader inputBufferedReader = null;
        HashMap<String, Long> keyCountHashMap = new HashMap<>(); // this map contains the sum of the key value as sum

        try {

            inputFile = new File(inputFilePath);
            inputFileReader = new FileReader(inputFile);
            inputBufferedReader = new BufferedReader(inputFileReader);
            String[] keyValuePair;

            while (inputBufferedReader.ready()) {
                try {

                    keyValuePair = inputBufferedReader.readLine().split(" ");
                    if (keyValuePair.length != 2) {
                        continue;
                    }
                    if (keyValuePair[0] == null || keyValuePair[0].isEmpty() || keyValuePair[1] == null || keyValuePair[1].isEmpty()) {
                        continue;
                    }

                    long valueofKey = Long.parseLong(keyValuePair[1]);

                    if (keyCountHashMap.containsKey(keyValuePair[0])) {
                        keyCountHashMap.put(keyValuePair[0], keyCountHashMap.get(keyValuePair[0]) + valueofKey);
                    } else {
                        keyCountHashMap.put(keyValuePair[0], valueofKey);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            printAndStoreOutputInfile(keyCountHashMap, outputFilePath);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputFile != null) {
                inputFile = null;
            }

            if (inputFileReader != null) {
                try {
                    inputFileReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (inputBufferedReader != null) {
                try {
                    inputBufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
    // this method write the output file as the sum of key
    private void printAndStoreOutputInfile(HashMap<String, Long> keyCountHashMap, String outputFilePath) {

        FileOutputStream fileOutputStream = null;
        OutputStreamWriter fileOutputStreamWriter = null;
        BufferedWriter outputBufferedWriter = null;

        try {
            fileOutputStream = new FileOutputStream(outputFilePath, true);
            fileOutputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputBufferedWriter = new BufferedWriter(fileOutputStreamWriter);

            for (String key : keyCountHashMap.keySet()) {
                try {
                    outputBufferedWriter.write(key + " " + keyCountHashMap.get(key) + "\n");
                    System.out.println(key + " " + keyCountHashMap.get(key));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (outputBufferedWriter != null) {
                try {
                    outputBufferedWriter.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    outputBufferedWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (fileOutputStreamWriter != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStreamWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        Exercise2 sumUpKey = new Exercise2();
        sumUpKey.SumUpKey("/home/tushar/NetBeansProjects/Assignment/resources/input.txt", "/home/tushar/NetBeansProjects/Assignment/resources/output.txt");
    }

}
