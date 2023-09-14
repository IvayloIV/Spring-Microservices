package soft2run.com.stripedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class StripeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StripeDemoApplication.class, args);
	}

}
