package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Geo  implements Serializable {
    private String lat;
    private String lng;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -7919308727887378246L;
}
