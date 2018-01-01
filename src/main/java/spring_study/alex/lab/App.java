package spring_study.alex.lab;

import spring_study.alex.lab.logger.ConsoleEventLogger;

public class App {
    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public void logEvent(String message) {
        consoleEventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client();
        app.consoleEventLogger = new ConsoleEventLogger();

        app.logEvent("Test");
    }
}
