package filesprocessing;

import java.io.File;

/**
 * Abstract class of filters that filtered by permissions characters.
 */
abstract class PermissionFilters extends Filter{
    private static final String RETURN_POSITIVE_FILES = "YES"; // The wanted permission do exist in the file.

    protected boolean returnPositiveAnswer;

    /**
     * Creates filter and checks if requires filter by existens of permission or unexistens.
     * @param permissionDemand: Receives YES or NO
     * @param isNot: Signs the filter as straight or reversed.
     */
    public PermissionFilters(String permissionDemand, boolean isNot) {
        this.isNot = isNot;
        this.returnPositiveAnswer = permissionDemand.equals(RETURN_POSITIVE_FILES);
    }

    /**
     * The filter method that each filter has. Filters according to the positive or negetive permission
     * demand. Calls the positiveFilter method and return it or return the opposite.
     * @param file: The file to check the filter condition on.
     * @return boolean - if the condition is correct or not.
     */
    public boolean specificFilter(File file){
        if (returnPositiveAnswer)
            return positiveFilter(file);
        return !positiveFilter(file);
    }

    /**
     * The method checks whether a permission is exist.
     * @param file: Given file to check
     * @return boolean
     */
    abstract boolean positiveFilter(File file);

}
