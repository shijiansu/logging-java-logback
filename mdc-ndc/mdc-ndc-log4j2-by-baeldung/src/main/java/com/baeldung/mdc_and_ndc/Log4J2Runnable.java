package com.baeldung.mdc_and_ndc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * In each thread, put logging messages in ThreadContext, which is configure with log4j2.xml of
 * ThreadContext format - %X{key}.
 */
public class Log4J2Runnable implements Runnable {

  private static final Logger LOGGER = LogManager.getLogger();

  private final Transaction tx;
  private TransferService service = new TransferServiceImpl();

  public Log4J2Runnable(Transaction tx) {
    this.tx = tx;
  }

  @Override
  public void run() {
    String transactionId = tx.getTransactionId();
    String sender = tx.getSender();

    // https://logging.apache.org/log4j/2.x/log4j-api/apidocs/org/apache/logging/log4j/ThreadContext.html
    // The MDC is managed on a per thread basis. To enable automatic inheritance of
    // copies of the MDC to newly created threads, enable the Log4j system property.
    ThreadContext.put("transaction.id", transactionId);
    ThreadContext.put("transaction.owner", sender);

    // Add transactionId and owner to NDC
    ThreadContext.push("tx.id = " + transactionId);
    ThreadContext.push("tx.owner = " + sender);

    try {
      boolean result = service.transfer(tx.getAmount());
      LOGGER.info("Transfer result: {}", result);
    } finally {
      // take out owner from the NDC stack
      ThreadContext.pop();
      // take out transactionId from the NDC stack
      ThreadContext.pop();
      ThreadContext.clearAll();
    }
  }
}