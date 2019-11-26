package filesprocessing;

import java.io.File;

/**
 * Created by seanco on 06/06/2017.
 */
public class Between extends Filter {

    private double leftLimit, rightLimit;

    public Between(double leftLimit, double rightLimit, boolean isNot){
        this.isNot = isNot;
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    public boolean specificFilter(File file){
        double fileSize = file.length() / 1000; // file.length is size in bytes.
        return (fileSize >= leftLimit) && (fileSize <= rightLimit);
    }


}
