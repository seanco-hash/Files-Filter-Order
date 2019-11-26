package filesprocessing;

import java.io.File;

/**
 * Created by seanco on 06/06/2017.
 */
public class Suffix extends Filter {
    private String suffixValue;

    public Suffix(String suffixValue, boolean isNot){
        this.suffixValue = suffixValue;
        this.isNot = isNot;
    }

    public boolean specificFilter(File file){
        char[] givenValueChars = suffixValue.toCharArray();
        char[] fileNameChars = file.getName().toCharArray();
        int fileCharsCounter = fileNameChars.length - 1;
        if (givenValueChars.length > fileNameChars.length)
            return false;
        for (int i = givenValueChars.length - 1; i >= 0; i--) {
            if (givenValueChars[i] != fileNameChars[fileCharsCounter])
                return false;
            fileCharsCounter --;
        }
        return true;
    }
}
