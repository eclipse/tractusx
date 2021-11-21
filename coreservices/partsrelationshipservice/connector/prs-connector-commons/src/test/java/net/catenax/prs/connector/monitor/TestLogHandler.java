package net.catenax.prs.connector.monitor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * A simple log handler to validate logger under unit tests {@link LoggerMonitorTests}.
 */
@Getter
public class TestLogHandler extends Handler {

    private final List<LogRecord> records = new ArrayList<>();

    @Override
    public void publish(LogRecord record) {
        records.add(record);
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {
        throw new RuntimeException("TestLogHandler shouldn't be reused outside tests scope.");
    }
}
