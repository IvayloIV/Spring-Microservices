package soft2run.com.stripedemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.exception.CardException;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentMethod;
import com.stripe.model.PaymentMethodCollection;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;
import com.stripe.param.PaymentMethodCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import soft2run.com.stripedemo.entity.paymentMethod.VCard;
import soft2run.com.stripedemo.entity.paymentMethod.VFpx;
import soft2run.com.stripedemo.entity.paymentMethod.VPaymentMethod;
import soft2run.com.stripedemo.entity.customer.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StripeController {

    @Autowired
    private RequestOptions requestOptions;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/customer/create")
    public String createCustomer() throws StripeException {
        VAddress vAddress = VAddress.builder()
                .city("Varna")
                .country("Bulgaria")
                .line1("Ulitsa Goren Chiflik 4")
                .line2("Ulitsa Goren Chiflik 6")
                .postalCode("9000")
                .state("Varna")
                .build();

        VAddress vAddress2 = VAddress.builder()
                .city("Sofia")
                .country("Romania")
                .line1("Ulitsa Petko Kucoto 1")
                .line2("Ulitsa Goren Chiflik 7")
                .postalCode("1000")
                .state("Sofia1")
                .build();

        VShipping vShipping = VShipping.builder()
                .address(vAddress2)
                .name("Mijav interes")
                .phone("0888888889")
                .build();

        VCustomField vCustomField1 = VCustomField.builder()
                .name("Pole name 1")
                .value("Pole value 1")
                .build();

        VCustomField vCustomField2 = VCustomField.builder()
                .name("Pole name 2")
                .value("Pole value 2")
                .build();

        VRenderingOptions renderingOptions = VRenderingOptions.builder()
                .amountTaxDisplay("exclude_tax") //TODO: ?
                .build();

        VInvoiceSettings vInvoiceSettings = VInvoiceSettings.builder()
                .customFields(new VCustomField[] {vCustomField1, vCustomField2})
                .defaultPaymentMethod("pm_1MqbkILuBm1dMyQTSmbLjr6b") //TODO: ?
                .footer("Kraka")
                .renderingOptions(renderingOptions)
                .build();

        VTax vTax = VTax.builder()
                .ipAddress("192.0.0.1")
                .build();

        VTaxIdData vTaxIdData1 = VTaxIdData.builder()
                .type("ca_bn")
                .value("123456789")
                .build();

        VTaxIdData vTaxIdData2 = VTaxIdData.builder()
                .type("eu_vat")
                .value("HR12345678912")
                .build();

        VCustomer vCustomer = VCustomer.builder()
                .address(vAddress)
                .description("Na Gosho descritiona")
                .email("pesho@abv.bg")
                .metadata(Map.of("kon", "da be", "kon 2", "ne be"))
                .name("Pesho Cge")
//                .paymentMethod("pm_1MqbkILuBm1dMyQTSmbLjr6b")
                .phone("0888888888")
                .shipping(vShipping)
                .balance(432L)
//                .coupon("7KvRgCiz")
                .invoicePrefix("IE4") //TODO: ?
//                .invoiceSettings(vInvoiceSettings)
                .nextInvoiceSequence(32L) //TODO: ?
                .preferredLocales(new String[] {"BG", "EN"})
                .promotionCode("promo_1Mqc4XLuBm1dMyQTHvO8Q4dY")
//                .source("cus_NbplCnRPKcvsp9") //TODO ?
                .tax(vTax)
                .taxExempt("exempt")
                .taxIdData(new VTaxIdData[] {vTaxIdData1, vTaxIdData2})
                .testClock("clock_1MqyVALuBm1dMyQTTyjoI6uf")
                .build();

        Map map = objectMapper.convertValue(vCustomer, Map.class);

        Customer customer = Customer.create(map, requestOptions);
        System.out.println(customer);
        return "OK";
    }

    @GetMapping("/paymentMethod/create")
    public String createPaymentMethod() throws StripeException {
        try {
            VCard vCard = VCard.builder()
                    .number("4111111111111111")
                    .expMonth(3)
                    .expYear(2026)
                    .cvc("314")
                    .build();

            VFpx vFpx = VFpx.builder()
                    .bank("ocbc")
                    .build();

            VPaymentMethod vPaymentMethod = VPaymentMethod.builder()
                    .type("alipay")
//                    .card(vCard)
//                    .fpx(vFpx)
//                    .alipay(PaymentMethod.Alipay.)
                    .build();

            PaymentMethod paymentMethodObj = new PaymentMethod();
            PaymentMethod.Alipay alipay = new PaymentMethod.Alipay();
            paymentMethodObj.setType("alipay");
            paymentMethodObj.setAlipay(alipay);

            PaymentMethodCreateParams params = new PaymentMethodCreateParams.Builder()
                    .setType(PaymentMethodCreateParams.Type.ALIPAY)
                    .setAlipay(PaymentMethodCreateParams.Alipay.builder().putExtraParam("currency", "1234567890abcdefg").build())
                    .build();

            Map map = objectMapper.convertValue(vPaymentMethod, Map.class);

            PaymentMethod paymentMethod = PaymentMethod.create(params, requestOptions);
            System.out.println(paymentMethod);
        } catch (CardException ex) {
            System.out.println(ex.getCode());
            System.out.println(ex.getMessage());
        }

        return "OK";
    }

    @GetMapping("/attach/customer")
    public String attachCustomer() throws StripeException {
        PaymentMethod paymentMethod = PaymentMethod.retrieve("pm_1MqGr9LuBm1dMyQTnQoEL4lz", requestOptions);

        Map<String, Object> params = new HashMap<>();
        params.put("customer", "cus_NbSlvUmtDqgAvn");

        PaymentMethod attached = paymentMethod.attach(params, requestOptions);
        System.out.println(attached);
        return "OK";
    }

    @GetMapping("/paymentMethods")
    public String paymentMethods() throws StripeException {
        PaymentMethodCollection paymentMethods =
                PaymentMethod.list(Map.of("type", "card", "customer", "cus_NbSlvUmtDqgAvn"), requestOptions);
        List<PaymentMethod> data = paymentMethods.getData();
        System.out.println(paymentMethods);
        return "OK";
    }

    @GetMapping("/token")
    public String createToken() throws StripeException {
        Map<String, Object> card = new HashMap<>();
        card.put("number", "4242424242424242");
        card.put("exp_month", 8);
        card.put("exp_year", 2025);
        card.put("cvc", "314");
        Map<String, Object> params = new HashMap<>();
        params.put("card", card);

        Token token = Token.create(params, requestOptions);
        System.out.println(token);
        return "OK";
    }
}
