package spring.boot.log4j2.by.xihuai;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class HelloBean {

  public String helloWorld() {
    log.error("Hi ! We have an Error. Hello World");
    return "Hello World ----spring-boot-log4j2";
  }
}
