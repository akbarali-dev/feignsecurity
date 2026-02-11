package uz.akbarali.tayyorgarlik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TayyorgarlikApplication {

    public static void main(String[] args) {
        SpringApplication.run(TayyorgarlikApplication.class, args);
    }

}
