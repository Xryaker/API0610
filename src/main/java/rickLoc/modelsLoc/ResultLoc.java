package rickLoc.modelsLoc;

import java.util.ArrayList;
import java.util.Date;

public class ResultLoc {
    public int id;
    public String name;
    public String type;
    public String dimension;
    public ArrayList<String> residents;
    public String url;
    public Date created;

    @Override
    public String toString() {
        return "name "+name+"\n"+
                "type "+type;
    }
}
