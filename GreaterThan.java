package filesprocessing;

import java.io.File;

/**
 * Created by seanco on 06/06/2017.
 */
public class GreaterThan extends Filter {

    private double greaterThanNum;

    public GreaterThan(double greaterThanNum, boolean isNot){
        this.greaterThanNum = greaterThanNum;
        this.isNot = isNot;
    }

    public boolean specificFilter(File file){return (file.length() / 1000) > greaterThanNum;}

}
