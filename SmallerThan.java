package filesprocessing;

import java.io.File;

/**
 * Created by seanco on 06/06/2017.
 */
public class SmallerThan extends Filter {

    private double smallerThanNum;

    public SmallerThan(double smallerThanNum, boolean isNot){
        this.smallerThanNum = smallerThanNum;
        this.isNot = isNot;
    }

    public boolean specificFilter(File file){return (file.length() / 1000) < smallerThanNum;}
}
