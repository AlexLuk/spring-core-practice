package spring_study.alex.lab.logger;

import spring_study.alex.lab.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
