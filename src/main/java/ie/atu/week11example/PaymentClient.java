package ie.atu.week11example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="payment-service", url = "http://localhost:8082/payment")
public interface PaymentClient {
    @PostMapping
    public String makePayment(Person person);
}
