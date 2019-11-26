package filesprocessing;

/**
 * The class represents a section as readed from the command file. Each section holds a Filter object and
 * Order object and its warnings.
 */
public class FilterOrderSection {
    private static final String ERR_MSG = "Warning in line ";
    private Filter filter;
    private Order order;
    private int errLine1, errLine2; // Max of 2 errors per section.

    /**
     * Creates section by receiving its filter, order and warning lines.
     * @param filter: Filter object
     * @param order: Order object
     * @param errLine1: line of error 1 if exists.
     * @param errLine2: line of error 2 if exists.
     */
    public FilterOrderSection(Filter filter, Order order, int errLine1, int errLine2){
        this.filter = filter;
        this.order = order;
        this.errLine1 = errLine1;
        this.errLine2 = errLine2;
    }

    /**
     * @return Filter: The filter of the section.
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * @return Order: The order of the section.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Prints the errors detected in the section if exists.
     */
    public void printErrors(){
        if (errLine1 > 0)
            System.out.println(ERR_MSG + errLine1);
        if (errLine2 > 0)
            System.out.println(ERR_MSG + errLine2);
    }
}
