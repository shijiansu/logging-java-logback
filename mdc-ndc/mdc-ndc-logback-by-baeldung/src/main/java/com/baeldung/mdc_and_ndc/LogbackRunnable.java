package com.baeldung.mdc_and_ndc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LogbackRunnable implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogbackRunnable.class);

  private final Transaction tx;

  public LogbackRunnable(Transaction tx) {
    this.tx = tx;
  }

  private TransferServiceImpl service = new TransferServiceImpl();

  public void run() {
    String transactionId = tx.getTransactionId();
    String sender = tx.getSender();

    MDC.put("transaction.id", transactionId);
    MDC.put("transaction.owner", sender);

    try {
      boolean result = service.transfer(tx.getAmount());
      LOGGER.info("Transfer result: {}", result);
    } finally {
      MDC.clear();
    }
  }
}