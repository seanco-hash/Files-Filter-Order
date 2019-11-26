package filesprocessing;

import java.io.File;

/**
 * Created by seanco on 06/06/2017.
 */
public class ContainsFilter extends Filter {
    private String valueToCheck;

    public ContainsFilter(String valueToCheck, boolean isNot){
        this.isNot = isNot;
        this.valueToCheck = valueToCheck;
    }

    public boolean specificFilter(File file){return file.getName().contains(valueToCheck);}

}
