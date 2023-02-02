package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class TestAPI {
    @Test
    public void test1(){

      // String jsonString= RestGet.GetExchange("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json");
        String jsonString=TEXTtest.get();
            JSONObject jsonExchange=new JSONObject(jsonString);
        System.out.println(jsonExchange.get("trackingParams"));//"trackingParams":"CAAQumkiEwiE17uAsPf8AhVbk1UKHc_qBV0="
        System.out.println(jsonExchange);

        JSONObject responseContext= jsonExchange.getJSONObject("responseContext");//responseContext:{object}

        JSONArray jsonArray =new JSONArray(responseContext.getJSONArray("serviceTrackingParams"));//"serviceTrackingParams":[]
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject= new JSONObject(jsonArray.get(i).toString());
            System.out.println(jsonObject.get("service"));
        }
    }
}
