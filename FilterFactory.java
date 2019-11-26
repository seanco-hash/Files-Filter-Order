package filesprocessing;

import java.util.Arrays;

/**
 * Created by Ori Kelner on 6/1/2017.
 */
public class FilterFactory {
    final String stringInitializer = "#";

    public FilterFactory(){
    }

    public Filter createFilter(String line){
        String[] lineInParts = splitLine(line);
        boolean hasNot = hasNot(lineInParts);
        if(hasNot) {
            String[] lineInPartsWithoutNot = Arrays.copyOfRange(lineInParts, 0, lineInParts.length - 1);
            return filterMaker(lineInPartsWithoutNot, hasNot);
        }
        else
            return filterMaker(lineInParts, hasNot);
    }

    private String[] splitLine(String line){
        String[] lineInParts = line.split("#");
        return lineInParts;
    }

    private boolean hasNot(String[] lineInParts) {
        if (lineInParts[lineInParts.length - 1].equals("NOT"))
            return true;
        return false;
    }

    private Filter filterMaker(String[] lineInParts, boolean hasNot){
        String value = stringInitializer;
        if (lineInParts.length > 3)
            return null;
        if(lineInParts.length > 1)
            value = lineInParts[1];
        switch (lineInParts[0]){
            case "greater_than" :
                if(Double.parseDouble(value) >= 0 && lineInParts.length == 2)
                    return new GreaterThan(Double.parseDouble(value), hasNot);
                break;
            case "smaller_than" :
                if(Double.parseDouble(value) >= 0 && lineInParts.length == 2)
                    return new SmallerThan(Double.parseDouble(value), hasNot);
                break;
            case "file" :
                if (value != null && lineInParts.length == 2)
                    return new FileFilter(value, hasNot);
                break;
            case "contains" :
                if (value != null && lineInParts.length == 2)
                    return new ContainsFilter(value, hasNot);
                break;
            case "prefix" :
                if (value != null && lineInParts.length == 2)
                    return new Prefix(value, hasNot);
                break;
            case "suffix" :
                if (value != null && lineInParts.length == 2)
                    return new Suffix(value, hasNot);
                break;
            case "writable" :
                if ((value.equals("YES")|| value.equals("NO")) && lineInParts.length == 2)
                    return new Writable(value, hasNot);
                break;
            case "executable" :
                if ((value.equals("YES")|| value.equals("NO")) && lineInParts.length == 2)
                    return new Executable(value, hasNot);
                break;
            case "hidden" :
                if ((value.equals("YES")|| value.equals("NO")) && lineInParts.length == 2)
                    return new Hidden(value, hasNot);
                break;
            case "all" :
                if(lineInParts.length == 1)
                    return new All(hasNot);
                break;
            case "between" :
                if (lineInParts.length == 3){
                    double valueOne = Double.parseDouble(lineInParts[1]);
                    double valueTwo =Double.parseDouble(lineInParts[2]);
                    if (valueOne >= 0 && valueTwo > valueOne)
                        return new Between(valueOne, valueTwo, hasNot);
                }
                break;

                default:
                    return null;
        }
        return null;
    }

}
