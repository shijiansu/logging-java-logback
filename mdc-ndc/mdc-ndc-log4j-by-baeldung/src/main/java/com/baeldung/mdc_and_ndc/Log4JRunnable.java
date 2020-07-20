package com.baeldung.mdc_and_ndc;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;

public class Log4JRunnable implements Runnable {

  private Logger LOGGER = Logger.getLogger(Log4JRunnable.class);
  private static TransferService service = new TransferServiceImpl();

  private Transaction tx;

  public Log4JRunnable(Transaction tx) {
    this.tx = tx;
  }

  public void run() {
    String transactionId = tx.getTransactionId();
    String sender = tx.getSender();

    // Add transactionId and owner to MDC
    MDC.put("transaction.id", transactionId);
    MDC.put("transaction.owner", sender);

    NDC.push("tx.id = " + transactionId);
    NDC.push("tx.owner = " + sender);

    try {
      boolean result = service.transfer(tx.getAmount());
      LOGGER.info(String.format("Transfer result: %s", result));
    } finally {
      NDC.pop(); // take out owner from the NDC stack
      NDC.pop(); // take out transactionId from the NDC stack
      NDC.remove();

      MDC.clear();
    }
  }
}