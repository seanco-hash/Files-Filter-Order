package filesprocessing;

import java.io.File;
import java.util.*;

/**
 * The class orders lists reversely according to any given comparator.
 */
public class ReversedOrder extends Order{
    private Comparator<File> orderToReverse;

    /**
     * The object receives a comparator object to reefer to in order to reverse it.
     * @param orderToReverse: comparator.
     */
    public ReversedOrder(Comparator<File> orderToReverse){
        this.orderToReverse = orderToReverse;
    }

    /**
     * Order files list in reversed order from the comparator order.
     * @param fileList: list of files.
     */
    public void orderBy(List<File> fileList){
        Collections.sort(fileList, this);
    }

    /**
     * Returns the opposite from the compare method of the given Comparator object.
     * @param file1: file1
     * @param file2: file2
     * @return int.
     */
    public int compare(File file1, File file2){
        return orderToReverse.compare(file1, file2) * -1; // returns the opposite from order compare to sort
        // reverse.
    }
}


