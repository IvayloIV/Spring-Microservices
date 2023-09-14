package soft2run.com.stripedemo.entity.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VCustomer {

    private VAddress address;

    private String description;

    private String email;

    private Map<String, String> metadata;

    private String name;

    private String paymentMethod;

    private String phone;

    private VShipping shipping;

    private Long balance;

    private String coupon;

    private String invoicePrefix;

    private VInvoiceSettings invoiceSettings;

    private Long nextInvoiceSequence;

    private String[] preferredLocales;

    private String promotionCode;

    private String source;

    private VTax tax;

    private String taxExempt;

    private VTaxIdData[] taxIdData;

    private String testClock;
}
