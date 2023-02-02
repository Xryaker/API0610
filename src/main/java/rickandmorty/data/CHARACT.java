package rickandmorty.data;

import java.util.ArrayList;
import java.util.Date;

public class CHARACT {
    public String id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public Location location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public Date created;
}
 class Location{
    public String name;
    public String url;
}

 class Origin{
    public String name;
    public String url;
}