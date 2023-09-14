package soft2run.com.stripedemo.entity.paymentMethod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VBacsDebit {

    private String accountNumber;

    private String sortCode;
}
