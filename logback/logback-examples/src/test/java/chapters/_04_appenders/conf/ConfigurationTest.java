package chapters._04_appenders.conf;

import org.junit.jupiter.api.Test;

public class ConfigurationTest {

  @Test
  void logbackConsole() {
    log("src/main/resources/chapters/_04_appenders/conf/logback-Console.xml");
  }

  @Test
  void logbackFileAppender() {
    log("src/main/resources/chapters/_04_appenders/conf/logback-FileAppender.xml");
  }

  @Test
  void logbackTimestamp() {
    log("src/main/resources/chapters/_04_appenders/conf/logback-Timestamp.xml");
  }

  @Test
  void logbackTimestampContextBirth() {
    log("src/main/resources/chapters/_04_appenders/conf/logback-Timestamp-ContextBirth.xml");
  }

  private void log(String configurationLocation) {
    ConfigurationTester.main(new String[]{configurationLocation});
  }
}
