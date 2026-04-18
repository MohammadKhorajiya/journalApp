package journalApplication.API.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class WeatherResponse {

    private Current current;

    @Getter
    @Setter
    public static class Current {

        @JsonProperty("temp_c")
        private double temperature;

        @JsonProperty("condition")
        private Condition condition;

        @JsonProperty("feelslike_c")
        private double feelslike;
    }

    @Getter
    @Setter
    public static class Condition {
        private String text;
    }
}


