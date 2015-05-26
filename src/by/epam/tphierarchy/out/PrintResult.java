package by.epam.tphierarchy.out;

import by.epam.tphierarchy.exception.LogicalException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by aterehovich on 5/22/15.
 */
public class PrintResult {

    private static String outputFilePath = "result/result.txt";
    private FileOutputStream fileOutputStream;

    public PrintResult() throws FileNotFoundException{
        fileOutputStream = new FileOutputStream(outputFilePath);
    }

    public void write(String result) throws LogicalException {
        if (result!=null && !result.isEmpty()) {
            byte[] byteResult = putResultIntoBox(result);

            try {
                fileOutputStream.write(byteResult);
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new LogicalException();
        }
    }

    public static String getOutputFilePath(){
        return outputFilePath;
    }

    private byte[] putResultIntoBox(String result){
        String inBox = "";
        for (int i =0; i<result.length()+2; i++){
            inBox+="*";
        }
        inBox+="\n";
        inBox+=result;
        inBox+="\n";
        for (int i =0; i<result.length()+2; i++){
            inBox+="*";
        }
        inBox+="\n";
        return inBox.getBytes();
    }

}
