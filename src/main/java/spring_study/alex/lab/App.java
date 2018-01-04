package spring_study.alex.lab;

import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import spring_study.alex.lab.logger.EventLogger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class App {
    private Client client;
    private EventLogger eventLogger;

    private void logEvent(Event event) {
        event.setMessage(
                event.getMessage().replaceAll(client.getId(), client.getFullName())
        );
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        List<ApplicationContext> contexts = new ArrayList<>();
        contexts.add(new ClassPathXmlApplicationContext("spring-configuration.xml"));
        contexts.add(new AnnotationConfigApplicationContext(AppConfig.class));
        contexts.add(new GenericGroovyApplicationContext("spring-configuration.groovy"));

        contexts.forEach(ctx -> {
            App app = ctx.getBean(App.class);
            Event event = new Event(new Date(System.currentTimeMillis()));
            event.setMessage(ctx.getDisplayName() + "\tSome event for user 1");
            app.logEvent(event);
        });

    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }
}
