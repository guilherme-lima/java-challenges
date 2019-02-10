package logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Created by guilherme-lima on 10/02/19.
 * https://github.com/guilherme-lima
 */
public abstract class MyLogger {

    protected MyLogger() {
    }

    protected static final Logger LOGGER;
    static {
        Logger mainLogger = Logger.getLogger("GenericLogger");
        mainLogger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + "\n";
            }
        });
        mainLogger.addHandler(handler);
        LOGGER = Logger.getLogger("GenericLogger");
    }
}