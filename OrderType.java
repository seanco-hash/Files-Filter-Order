package filesprocessing;

import java.io.File;

/**
 * The class orders files list by their type.
 */
public class OrderType extends Order{
    private static final String PARTITION_SYMBOL = ".";
    private static final String NO_DECLARED_TYPE = " ";

    /**
     * Creates instance and marks itself if it is straight or reversed order.
     * @param isReversed: if true - reversed order was asked.
     */
    public OrderType(boolean isReversed) {
        this.isReversed = isReversed;
    }

    /**
     * The method defines how to compare between two files according to their type. Finds the files types
     * and compare between them by alphabetic comparison.
     * @param file1: file1
     * @param file2: file2
     * @return int: 1 if file 1 > file 2, -1 if file1 < file2, 0 if file1 == file2
     */
    public int compare(File file1, File file2) {
        String[] splicedName1 = file1.getName().split(PARTITION_SYMBOL);
        String[] splicedName2 = file2.getName() .split(PARTITION_SYMBOL);
        String type1, type2;
        // If splicedPath <= 1 It means that "." is at the end or beginning ot not exist.
        type1 = splicedName1.length <= 1 ? NO_DECLARED_TYPE : splicedName1[splicedName1.length - 1];
        type2 = splicedName2.length <= 1 ? NO_DECLARED_TYPE : splicedName2[splicedName2.length - 1];

        int compareTypes = type1.compareTo(type2);
        if (compareTypes == 0) // If types are equal, sort by Abs.
            return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
        return compareTypes;
    }
}
