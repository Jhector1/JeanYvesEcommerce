package art.jeanyvehector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class JeanyvehectorApplication {

    public static void main(String[] args) {



        SpringApplication.run(JeanyvehectorApplication.class, args);
        System.out.println("Spring Framework Version: " + SpringVersion.getVersion());
    }

}
