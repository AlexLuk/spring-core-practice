import spring_study.alex.lab.*
import spring_study.alex.lab.logger.ConsoleEventLogger
import spring_study.alex.lab.logger.EventLogger

beans {
    framework String, 'Grails'
    client (Client, '1', 'John Smith')
    eventLogger ConsoleEventLogger
    app (App, eventLogger, client)
}