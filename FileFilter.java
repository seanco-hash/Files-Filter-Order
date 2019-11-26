package filesprocessing;

import java.io.File;

/**
 * Created by seanco on 06/06/2017.
 */
public class FileFilter extends Filter {
    private String compareToName;

    public FileFilter(String compareToName, boolean isNot){
        this.compareToName = compareToName;
        this.isNot = isNot;
    }

    public boolean specificFilter(File file){return file.getName().equals(compareToName);}
}
