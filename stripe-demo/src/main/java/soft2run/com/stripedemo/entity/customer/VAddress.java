package soft2run.com.stripedemo.entity.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VAddress {

    private String city;

    private String country;

    private String line1;

    private String line2;

    private String postalCode;

    private String state;
}
