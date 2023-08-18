package br.com.fiap.creditcardpayment.function;

import br.com.fiap.creditcardpayment.entity.SaleRequest;
import br.com.fiap.creditcardpayment.entity.SaleResponse;
import br.com.fiap.creditcardpayment.service.SaleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class SalesFunction {
    @Bean
    public Function<SaleRequest, SaleResponse> generateToken(SaleService service) {
        return service::sale;
    }
}
