package rickandmorty.data;

import java.util.HashMap;
import java.util.Map;

public class CHARACKTERS {
    static private Map<String,CHARACT> charactMap=new HashMap<>();

    public static Map<String, CHARACT> getCharactMap() {
        return charactMap;
    }

    public static void setCharact(String url,CHARACT charact) {
        charactMap.put(url, charact);
    }
}
