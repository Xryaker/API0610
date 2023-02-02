package resttest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;
import resttest.models.ExchangeJ;
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class TestModels {
    static String url="https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json";

    static ExchangeJ exchangeJ;
    @BeforeClass
    public static void startData() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        exchangeJ=om.readValue(RestGet.GetExchange(url), ExchangeJ.class);
    }

    @Test
    public void testAPI(){
        System.out.println(exchangeJ.txt);
        Assert.assertEquals(String.valueOf(36.5686),String.valueOf(exchangeJ.rating));
    }
}
