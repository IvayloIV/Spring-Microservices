package soft2run.com.stripedemo.entity.paymentMethod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VUsBankAccount {

    private String accountHolderType;

    private String accountNumber;

    private String accountType;

    private Integer routingNumber;
}
