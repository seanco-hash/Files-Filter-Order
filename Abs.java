package filesprocessing;

import java.io.File;

/**
 * The class orders files list by their name.
 */
public class Abs extends Order {

    /**
     * Creates instance and marks itself if it is straight or reversed order.
     * @param isReversed: if true - reversed order was asked.
     */
    public Abs(boolean isReversed) {
        this.isReversed = isReversed;
    }

    /**
     * The method compares between two files by their name (alphabeticly)
     * @param file1: file1
     * @param file2: file2
     * @return int: 1 if file 1 > file 2, -1 if file1 < file2, 0 if file1 == file2
     */
    public int compare(File file1, File file2) {

        String name1 = file1.getAbsolutePath();
        String name2 = file2.getAbsolutePath();

        return name1.compareTo(name2);
    }

}
