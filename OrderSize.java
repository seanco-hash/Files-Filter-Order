package filesprocessing;

import java.io.File;


/**
 * The class orders files list by their size.
 */
public class OrderSize extends Order {

    /**
     * Creates instance and marks itself if it is straight or reversed order.
     * @param isReversed: if true - reversed order was asked.
     */
    public OrderSize(boolean isReversed) {
        this.isReversed = isReversed;
    }

    /**
     * compares between files by their size. If the sizes are equal, compares by abs.
     * @param file1: file 1
     * @param file2: file 2
     * @return non-negative number if file 1 size is larger than file 2 size and negative number else. If
     * sizes are equal, returns negative or non-negative numbers by comparing files names.
     */
    public int compare(File file1, File file2) {
        long size1 = file1.length();
        long size2 = file2.length();
        if (size1 == size2) // If sizes are equal, sort by Abs.
            return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
        return size1 > size2 ? 1 : -1;
    }
}
