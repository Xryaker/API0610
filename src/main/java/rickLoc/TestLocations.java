package rickLoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.RestGet;
import resttest.models.ExchangeJ;
import rickLoc.modelsLoc.LocationModel;
import rickLoc.modelsLoc.ResultLoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestLocations {
    static String url = "https://rickandmortyapi.com/api/location";
    static List<String> listUrls = new ArrayList<>();
static ObjectMapper om;
    @BeforeClass
    public static void startData() throws JsonProcessingException {
        listUrls.add(url);
         om= new ObjectMapper();
        while (true) {
            LocationModel locationModel = om.readValue(RestGet.GetExchange(url), LocationModel.class);
            if (!Objects.equals(locationModel.info.next, null)) {
                listUrls.add(locationModel.info.next);
                url = locationModel.info.next;
            } else {
                break;
            }
        }
        for (String l : listUrls) {
            System.out.println(l);
        }
    }


    @Test
    public void test() throws JsonProcessingException {
        for (String l:listUrls){
            LocationModel model=om.readValue(RestGet.GetExchange(l), LocationModel.class);
            for(ResultLoc r:model.results){
                System.out.println("------------------------------");
                System.out.println(r);
            }
        }
    }
}
