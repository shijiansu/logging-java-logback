package chapters._06_layouts;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LayoutTest {

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
  void mySampleLayoutConfig() throws JoranException {
    init("src/main/resources/chapters/_06_layouts/mySampleLayout.xml");
    logMessage(logger);
  }

  @Test
  void mySampleLayout2WithOption() throws JoranException {
    init("src/main/resources/chapters/_06_layouts/mySampleLayout2WithOption.xml");
    logMessage(logger);
  }

  @Test
  void highlighted() throws JoranException {
    init("src/main/resources/chapters/_06_layouts/highlighted.xml");
    logMessage(logger);
  }

  @Test
  void customizedSampleConverter() throws JoranException {
    init("src/main/resources/chapters/_06_layouts/customizedSampleConverter.xml");
    logMessage(logger);
  }

  private void logMessage(Logger logger) {
    Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        .map(String::valueOf)
        .forEach(logger::debug);
    logger.info("Everything's going well");
    logger.error("maybe not quite...");
  }
}
