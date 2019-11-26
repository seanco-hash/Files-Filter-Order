package filesprocessing;

import java.io.File;

/**
 * Created by seanco on 06/06/2017.
 */
public class Executable extends PermissionFilters {

    public Executable(String permissionDemand, boolean isNot) {super(permissionDemand, isNot);}

    public boolean positiveFilter(File file) {return file.canExecute();}
}
