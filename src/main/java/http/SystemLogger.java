package http;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ahmad on 2/6/17.
 */
public class SystemLogger implements Logger {
    private static final String LEVEL_ERROR = "ERROR: ";
    private static final String LEVEL_WARNING = "WARNING: ";
    private static final String LEVEL_DEBUG = "DEBUG: ";
    private static final String LEVEL_INFO = "INFO: ";
    private static final String LEVEL_VERBOSE = "VERBOSE: ";

    PrintWriter writer;
    SimpleDateFormat dateFormat;

    public SystemLogger() {
        this("def.log");
    }

    public SystemLogger(String fileName) {
        dateFormat = new SimpleDateFormat("dd MMM, kk:mm:ss");
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logError(String message) {
        System.err.println(LEVEL_ERROR + message);
        write(loggingMessage(LEVEL_ERROR, message));
    }

    @Override
    public void logWarning(String message) {
        System.out.println(LEVEL_WARNING + message);
        write(loggingMessage(LEVEL_WARNING, message));
    }

    @Override
    public void logDebug(String message) {
        System.out.println(LEVEL_DEBUG + message);
        write(loggingMessage(LEVEL_DEBUG, message));
    }

    @Override
    public void logInfo(String message) {
        System.out.println(LEVEL_INFO + message);
        write(loggingMessage(LEVEL_INFO, message));
    }

    @Override
    public void logVerbose(String message) {
        System.out.println(LEVEL_VERBOSE + message);
        write(loggingMessage(LEVEL_VERBOSE, message));
    }

    String loggingMessage(String logLevel, String originalMessage) {
        return String.format("%s %s: %s", dateFormat.format(new Date()), logLevel, originalMessage);
    }

    void write(String log) {
        writer.println(log);
        writer.flush();
    }
}
