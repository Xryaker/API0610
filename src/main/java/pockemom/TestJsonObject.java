package pockemom;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;

public class TestJsonObject {

    static JSONObject pockemon;

    @BeforeClass
    public static void getObject() {
        String stringRequest = RestGet.GetExchange("https://pokeapi.co/api/v2/berry-firmness/");
        pockemon = new JSONObject(stringRequest);
    }

    @Test
    public void test1() {
        System.out.println(pockemon.toString());
    }

    @Test
    public void testField() {
        Assert.assertNotNull("count null", pockemon.get("count"));
        System.out.println("count = " + pockemon.get("count"));
    }

    @Test
    public void testFieldInMassive() {
        JSONArray resultsPockemon = new JSONArray(pockemon.getJSONArray("results"));
        for(int i=0;i<resultsPockemon.length();i++){
            JSONObject tempJsonObject=new JSONObject(resultsPockemon.get(i).toString());
            System.out.println(tempJsonObject);
            Assert.assertNotNull("field name is null",tempJsonObject.get("name"));
           // System.out.println(tempJsonObject.get("name"));
        }
    }
}
