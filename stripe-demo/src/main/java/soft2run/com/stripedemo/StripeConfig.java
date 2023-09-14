package soft2run.com.stripedemo;

import com.stripe.net.RequestOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Bean
    public RequestOptions requestOptions() {
        return RequestOptions.builder()
                .setApiKey("API_KEY")
                .build();
    }
}
