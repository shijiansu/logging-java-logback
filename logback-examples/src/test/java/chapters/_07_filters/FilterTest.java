package chapters._07_filters;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterTest {

  Logger logger;

  private void init(String configurationLocation) throws JoranException {
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    JoranConfigurator configurator = new JoranConfigurator();
    configurator.setContext(lc);
    lc.reset();
    configurator.doConfigure(configurationLocation);
    logger = LoggerFactory.getLogger(this.getClass());
  }

  @Test
  void customizedFilter() throws JoranException {
    init("src/main/resources/chapters/_07_filters/customizedFilter.xml");
    logMessage(logger); // shall only come 1 log record
  }

  @Test
  void levelFilter() throws JoranException {
    init("src/main/resources/chapters/_07_filters/levelFilter.xml");
    logMessage(logger); // only print info level
  }

  @Test
  void thresholdFilter() throws JoranException {
    init("src/main/resources/chapters/_07_filters/thresholdFilter.xml");
    logMessage(logger); // only print info or above levels
  }

  @Test
  @Disabled("Because gEventEvaluator does not exist at logback.version 1.3.0-alpha4")
  void gEventEvaluator() throws JoranException {
    init("src/main/resources/chapters/_07_filters/gEventEvaluator.xml");
    logMessage(logger);
  }

  @Test
  void janinoEventEvaluator() throws JoranException {
    init("src/main/resources/chapters/_07_filters/eventEvaluator.xml");
    logMessage(logger); // only show billing log record
  }

  @Test
  void janinoEventEvaluatorWithMatcher() throws JoranException {
    init("src/main/resources/chapters/_07_filters/eventEvaluatorWithMatcher.xml");
    logMessage(logger); // filter out 13579, because 1, so 10, 11, ... are all out
  }

  // TurboFilter objects are tied to the logging context.
  // turbo filters are intended for high performance filtering of logging events

  private void logMessage(Logger logger) {
    Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        .map(String::valueOf)
        .forEach(logger::debug);
    logger.info("Everything's going well");
    logger.error("maybe not quite...");
    logger.error("sample...");
    logger.error("billing");
  }
}
