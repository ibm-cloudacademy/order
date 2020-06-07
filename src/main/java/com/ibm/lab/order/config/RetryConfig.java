package com.ibm.lab.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryConfig {

	@Bean
	public RetryTemplate retryTemplate() {
		RetryTemplate retryTemplate = new RetryTemplate();
		
		FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
		// 재시도 간격 설정
		fixedBackOffPolicy.setBackOffPeriod(2000l);
		retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
		
		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		retryPolicy.setMaxAttempts(5);
		retryTemplate.setRetryPolicy(retryPolicy);
		
		return retryTemplate;
	}
}
