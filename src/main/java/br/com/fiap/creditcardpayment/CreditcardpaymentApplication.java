package br.com.fiap.creditcardpayment;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableScan
@EnableFeignClients
@SpringBootApplication
public class CreditcardpaymentApplication {
	public static void main(String[] args) {
		SpringApplication.run(CreditcardpaymentApplication.class, args);
	}
}