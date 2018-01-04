package spring_study.alex.lab;

import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import spring_study.alex.lab.logger.EventLogger;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class App {
    private Client client;
    private EventLogger eventLogger;

    private void logEvent(String message) {
        String msg = message.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(msg);
    }

    public static void main(String[] args) {
        List<ApplicationContext> contexts = new ArrayList<>();
        contexts.add(new ClassPathXmlApplicationContext("spring-configuration.xml"));
        contexts.add(new AnnotationConfigApplicationContext(AppConfig.class));
        contexts.add(new GenericGroovyApplicationContext("spring-configuration.groovy"));

        contexts.forEach(ctx -> {
            App app = ctx.getBean(App.class);
            app.logEvent(ctx.getDisplayName() + "\tSome event for user 1");
        });

    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }
}
