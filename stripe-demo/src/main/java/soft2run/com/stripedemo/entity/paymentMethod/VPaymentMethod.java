package soft2run.com.stripedemo.entity.paymentMethod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VPaymentMethod {

    private String type;

    private VBillingDetails billingDetails;

    private Map<String, String> metadata;

    private VAcssDebit acssDebit;

    private VAuBecsDebit auBecsDebit;

    private VBacsDebit vBacsDebit;

    private VBoleto boleto;

    private VCard card;

    private VFpx fpx;

    private VIdeal ideal;

    private VKlarna klarna;

    private VP24 p24;

    private VRadarOptions radarOptions;

    private VSepaDebit sepaDebit;

    private VSofort sofort;

    private VUsBankAccount usBankAccount;
}
