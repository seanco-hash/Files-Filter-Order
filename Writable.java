package filesprocessing;

import java.io.File;

public class Writable extends PermissionFilters {

    public Writable(String permissionDemand, boolean isNot) {super(permissionDemand, isNot);}

    public boolean positiveFilter(File file) {return file.canWrite();}
}














