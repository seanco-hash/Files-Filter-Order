package filesprocessing;

import java.io.File;

/**
 * Created by seanco on 06/06/2017.
 */
public class All extends Filter {

    public All(boolean isNot) {
        this.isNot = isNot;
    }

    public boolean specificFilter(File file) {
        return true;
    }
}
