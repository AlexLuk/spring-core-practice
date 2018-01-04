package spring_study.alex.lab;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_study.alex.lab.logger.ConsoleEventLogger;
import spring_study.alex.lab.logger.EventLogger;

@Configuration
@NoArgsConstructor
public class AppConfig {
    @Bean
    public App app() {
        return new App(client(),eventLogger());
    }

    @Bean
    public Client client() {
        return new Client("1","John Smith");
    }

    @Bean
    public EventLogger eventLogger(){
        return new ConsoleEventLogger();
    }
}
