package soft2run.com.stripedemo.entity.paymentMethod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import soft2run.com.stripedemo.entity.customer.VAddress;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VBillingDetails {

    private VAddress address;

    private String email;

    private String name;

    private String phone;
}
