package by.akulich.gcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcsApplication.class, args);
    }

}
