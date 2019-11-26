package filesprocessing;

import java.io.File;

/**
 * The class represents Filter object. This object receives a file and some requested parameter and then
 * checks if the file fills the parameter condition.
 */
abstract class Filter {
    // Each filter can return a reversed answer to its original straight filter. The boolean var holds the
    // input demand to straight or reversed filter.
    protected boolean isNot;

    /**
     * Acts the filter. Returns the filter answer or its opposite refer to the isNot boolean request.
     * @param file: File to filter
     * @return boolean.
     */
    public boolean doFilter(File file){
        if (isNot)
            return !specificFilter(file);
        return specificFilter(file);
    }

    /**
     * Checks file refer to specific condition. Returns True if the condition exists and false otherwise.
     * @param file: File to filter
     * @return boolean: True if fills the condition, False otherwise.
     */
    abstract boolean specificFilter(File file);

}

