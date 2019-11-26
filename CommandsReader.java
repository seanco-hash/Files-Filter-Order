package filesprocessing;


import java.io.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Ori Kelner on 5/25/2017.
 */
public class CommandsReader {
    private final String FILTER_STRING = "FILTER";
    private final String ORDER_STRING = "ORDER";
    private File file;
    private String curLine;
    private FilterFactory filterFactory;
    private OrderFactory orderFactory;
    private int filterErrorLine, orderErrorLine, counter;
    private Order curOrder;
    private Filter curFilter;
    private final String ERROR_MESSAGE = "We have a problem in line ";
    private List<FilterOrderSection> Sections;
    private boolean filterFlag;

    public CommandsReader(File commandFile) throws IOException {
        file = commandFile;
        filterFactory = new FilterFactory();
        orderFactory = new OrderFactory();
    }

    public List<FilterOrderSection> cutToSections() throws Exception {
        counter = 0;
        filterErrorLine = -1;
        orderErrorLine = -1;
        Sections = new LinkedList<FilterOrderSection>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((curLine!= null)) {
                // TO DO - MAKE SURE BR IS MOVING INSIDE THE METHOD!!!
                FilterReader(br);
                OrderReader(br);
                Sections.add(new FilterOrderSection(curFilter, curOrder, filterErrorLine, orderErrorLine));
                if (!filterFlag)
                    curLine = br.readLine();
                filterFlag = false;
                filterErrorLine = -1;
                orderErrorLine = -1;
                }
            }
        return Sections;
    }

    private void FilterReader(BufferedReader br) throws Exception {
        try {
            counter++;
            if (curLine.equals(FILTER_STRING)) {
                curLine = br.readLine();
                counter++;
                curFilter = filterFactory.createFilter(curLine);
                if (curFilter == null) {
                    curFilter = new All(false);
                    filterErrorLine = counter;
                    }
                }
            // Type 2 No Filter Section
            else {
                throw new ExceptionTypeTwo(ERROR_MESSAGE + counter);
            }
        } catch (NullPointerException exception) {
            throw new ExceptionTypeTwo(ERROR_MESSAGE + counter);
        }
    }

    private void OrderReader (BufferedReader br) throws Exception{
    try {
        curLine = br.readLine();
        counter++;
        if (curLine.equals(ORDER_STRING)) {
            curLine = br.readLine();
            counter++;
            if(curLine.equals(FILTER_STRING)) {
                curOrder = new Abs(false);
                filterFlag = true;
            }
            else {
                curOrder = orderFactory.createOrder(curLine);
                if (curOrder == null) {
                    curOrder = new Abs(false);
                    orderErrorLine = counter;
                }
            }
            // Type 2
        }
        else {
            throw new ExceptionTypeTwo(ERROR_MESSAGE + counter);
        }
    }
    catch (NullPointerException exception){
        throw new ExceptionTypeTwo(ERROR_MESSAGE +counter);
        }
    }
}

