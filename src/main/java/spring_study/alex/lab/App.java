package spring_study.alex.lab;

import spring_study.alex.lab.logger.ConsoleEventLogger;
import spring_study.alex.lab.logger.EventLogger;

public class App {
    private Client client;
    private EventLogger eventLogger;

    private void logEvent(String message) {
        String msg = message.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(msg);
    }

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client("1", "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public App() {
    }
}
