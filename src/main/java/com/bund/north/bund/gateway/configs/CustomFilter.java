package com.bund.north.bund.gateway.configs;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
	public CustomFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		//Custom Pre Filter. Suppose we can extract JWT and perform Authentication
		return (exchange, chain) -> {
			System.out.println("First pre filter" + exchange.getRequest());
			//Custom Post Filter.Suppose we can call error response handler based on error code.
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("First post filter");
			}));
		};
	}

	public static class Config {

	}
}
