package pockemom;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Firmness{
    @JsonProperty("count")
    public int count;
    @JsonProperty("next")
    public Object ext;
    public Object previous;
    public ArrayList<Result> results;
}
