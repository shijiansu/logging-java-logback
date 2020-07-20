package spring.boot.log4j2.by.xihuai;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements ApplicationRunner {

  private static final Logger logger = LogManager.getLogger(Application.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext c = SpringApplication.run(Application.class, args);
    HelloBean helloBean = c.getBean(HelloBean.class);
    helloBean.helloWorld();
    c.close();
  }

  @Override
  public void run(ApplicationArguments applicationArguments) {
    logger.debug("Debugging log");
    logger.info("Info log");
    logger.warn("Hey, This is a warning!");
    logger.error("Oops! We have an Error. OK");
    logger.fatal("Damn! Fatal error. Please fix me.");
  }
}
