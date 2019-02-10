package logger;

import com.hackerrank.work_schedule.WorkSchedule;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Created by guilherme-lima on 10/02/19.
 * https://github.com/guilherme-lima
 */
public abstract class MyLogger {

    protected static final Logger LOGGER;
    static {
        Logger mainLogger = Logger.getLogger(WorkSchedule.class.getPackage().getName());
        mainLogger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + "\n";
            }
        });
        mainLogger.addHandler(handler);
        LOGGER = Logger.getLogger(WorkSchedule.class.getName());
    }
}