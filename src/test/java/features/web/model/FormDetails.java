package features.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FormDetails {

    private final String name;
    private final String country;
    private final String city;
    private final String creditCard;
    private final String Month;
    private final String year;

}
