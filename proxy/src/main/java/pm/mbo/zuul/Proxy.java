package pm.mbo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Add ?debug=true to a request for zuul debug header.
 */
@SpringBootApplication
@EnableZuulProxy
public class Proxy {

	public static void main(final String... args) {
		SpringApplication.run(Proxy.class, args);
	}

}
