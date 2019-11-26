package filesprocessing;

import java.io.File;


public class Prefix extends Filter {
    private String prefixValue;

    public Prefix(String prefixValue, boolean isNot){
        this.prefixValue = prefixValue;
        this.isNot = isNot;
    }

    public boolean specificFilter(File file){
        char[] givenValueChars = prefixValue.toCharArray();
        char[] fileNameChars = file.getName().toCharArray();
        if (givenValueChars.length > fileNameChars.length)
            return false;
        for (int i = 0; i < givenValueChars.length; i++){
            if (givenValueChars[i] != fileNameChars[i])
                return false;
        }
        return true;
    }
}
