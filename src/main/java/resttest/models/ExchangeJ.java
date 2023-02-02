package resttest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeJ {
    public int r030;
    public String txt;
    @JsonProperty("rate")
    public double rating;
    public String cc;
    public String exchangedate;
}
