package pockemom;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class TestJsonObjectPrser {

    static ObjectMapper om;
    static Firmness firmness;

    @BeforeClass
    public static void getObject() throws JsonProcessingException {
        String stringRequest = RestGet.GetExchange("https://pokeapi.co/api/v2/berry-firmness/");
        om = new ObjectMapper();
        firmness = om.readValue(stringRequest, Firmness.class);
    }

    @Test
    public void test1() {
        for(Result l: firmness.results){
            Assert.assertNotNull("name is null",l.ame);
        }
    }
    @Test
    public void test2(){
        System.out.println(firmness.count);
    }
}
