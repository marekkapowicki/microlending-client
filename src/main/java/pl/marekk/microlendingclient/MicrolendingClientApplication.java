package pl.marekk.microlendingclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicrolendingClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrolendingClientApplication.class, args);
    }
}
