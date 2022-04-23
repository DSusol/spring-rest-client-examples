package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Address  implements Serializable {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -3456220023350258369L;
}
