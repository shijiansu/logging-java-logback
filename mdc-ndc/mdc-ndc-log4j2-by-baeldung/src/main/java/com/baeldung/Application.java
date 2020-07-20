package com.baeldung;

import static com.baeldung.mdc_and_ndc.Transaction.TransactionFactory.newInstance;

import com.baeldung.mdc_and_ndc.Log4J2Runnable;
import com.baeldung.mdc_and_ndc.Transaction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private static final Logger LOGGER = LogManager.getLogger();

  public static void main(String[] args) {
    LOGGER.info("Start main()...");
    SpringApplication.run(Application.class, args).close();
    LOGGER.info("Completed main()...");
  }

  @Override
  public void run(String... args) throws Exception {
    LOGGER.info("Start to process multiple threads...");

    ExecutorService executor = Executors.newFixedThreadPool(3);
    for (int i = 0; i < 10; i++) {
      Transaction tx = newInstance();
      Runnable task = new Log4J2Runnable(tx);
      executor.submit(task);
    }
    executor.shutdown();
    executor.awaitTermination(60, TimeUnit.SECONDS);

    LOGGER.info("Completed the process of multiple threads...");
  }
}
