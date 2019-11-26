package filesprocessing;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Abstract class that defines an Order object, that can order list of files by different wanted categories.
 */
abstract class Order implements Comparator<File>{
    protected boolean isReversed; // Marks the order object if it orders from low to high or high to low.

    /**
     * Order files list low to high or high to low by demand.
     * @param fileList: the files list.
     */
    public void orderBy(List<File> fileList){
        if (isReversed)
            new ReversedOrder(this).orderBy(fileList);
        else
            Collections.sort(fileList, this);
    }
}
