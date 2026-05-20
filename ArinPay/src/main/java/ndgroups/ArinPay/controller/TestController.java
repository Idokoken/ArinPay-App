package ndgroups.ArinPay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String getMessage(){
        String message = "Welcome to Arinpay System";
        return message;
    }
}
