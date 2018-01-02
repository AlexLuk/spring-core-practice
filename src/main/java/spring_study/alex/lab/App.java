package spring_study.alex.lab;

import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_study.alex.lab.logger.EventLogger;

@NoArgsConstructor
public class App {
    private Client client;
    private EventLogger eventLogger;

    private void logEvent(String message) {
        String msg = message.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(msg);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-configuration.xml");

        App app = (App) ctx.getBean("app");

        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
        app.logEvent("Some event for user 3");
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }
}
