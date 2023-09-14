package soft2run.com.stripedemo.entity.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VShipping {

    private VAddress address;

    private String name;

    private String phone;
}
