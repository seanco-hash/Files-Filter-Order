package filesprocessing;

/**
 * Factory that creates Order objects by the type of order requested.
 */
public class OrderFactory {
    // Type of orders as given.
    private static final String REVERSED_ORDER = "REVERSE";
    private static final String ORDER_BY_ABS = "abs";
    private static final String ORDER_BY_SIZE = "size";
    private static final String ORDER_BY_TYPE = "type";

    /**
     * Default constructor/
     */
    public OrderFactory(){}

    /**
     * Receives string and creates the order from the type mentioned in the string
     * @param orderCommand: wanted type of order.
     * @return Order object.
     */
    public Order createOrder(String orderCommand){
        // in case no order type in the file.`
        if (orderCommand == null)
            return new Abs(false);
        boolean isReversed = false;
        String[] words = orderCommand.split("#");
        if (words.length > 1){
            if (words[1].equals(REVERSED_ORDER))
                isReversed = true;
        }
        switch (words[0]){
            case ORDER_BY_ABS:
                return new Abs(isReversed);
            case ORDER_BY_SIZE:
                return new OrderSize(isReversed);
            case ORDER_BY_TYPE:
                return new OrderType(isReversed);
            default:
                return null; // unexpected input cause order by abs.
        }
    }
}
