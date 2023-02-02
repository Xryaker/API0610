package rickandmorty;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.RestGet;
import rickandmorty.data.CHARACKTERS;
import rickandmorty.data.CHARACT;
import rickandmorty.data.DataProvideR;
import rickandmorty.model.EpisodeModel;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RunWith(Parameterized.class)
public class TestRickAndMorty extends BaseApiTestRickandMorty {
    EpisodeModel episodeModel;
    ObjectMapper om;
    public TestRickAndMorty(String episodeNumber) throws JsonProcessingException {
        System.out.println(MAIN_URL + "/episode/" + episodeNumber);
        om= new ObjectMapper();
        String responce=RestGet.GetExchange(MAIN_URL + "/episode/" + episodeNumber + "/");
      //  System.out.println(responce);
        episodeModel = om.readValue(responce
                , EpisodeModel.class);
    }

    @Parameterized.Parameters
    public static Collection options() {
        return DataProvideR.getEpisodes();
    }

    @Test
    public void test() throws IOException {
        System.out.println(episodeModel.name);
        List<String> stringListUrlCharac=episodeModel.characters;
        for(String l:stringListUrlCharac){
            URL www = new URL(l);
            CHARACT charact=om.readValue(www,CHARACT.class);
            CHARACKTERS.setCharact(l,charact);
        }
    }
    @AfterClass
    public static void after(){
        System.out.println(CHARACKTERS.getCharactMap().values().size());
        Map<String,CHARACT> map=CHARACKTERS.getCharactMap();
        for (Map.Entry<String, CHARACT> m:map.entrySet()){
            System.out.println(m.getValue().name+" "+m.getValue().status);
        }
    }
}
