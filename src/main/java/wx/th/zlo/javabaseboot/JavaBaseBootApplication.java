package wx.th.zlo.javabaseboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaBaseBootApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(JavaBaseBootApplication.class, args);


    }

}
