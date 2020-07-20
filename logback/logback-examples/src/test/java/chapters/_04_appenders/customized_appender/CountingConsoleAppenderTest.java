package chapters._04_appenders.customized_appender;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountingConsoleAppenderTest {

  Logger logger;

  @BeforeEach
  void init() {
    String configurationLocation =
        "src/main/resources/chapters/_04_appenders/customized_appender/countingConsole.xml";
    logger = LoggerFactory.getLogger(this.getClass());
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

    try {
      JoranConfigurator configurator = new JoranConfigurator();
      configurator.setContext(lc);
      lc.reset();
      configurator.doConfigure(configurationLocation);
    } catch (JoranException je) {
      je.printStackTrace();
    }
  }

  @Test
  void logbackConsole() {
    Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        .map(String::valueOf)
        .forEach(logger::debug);
  }
}
