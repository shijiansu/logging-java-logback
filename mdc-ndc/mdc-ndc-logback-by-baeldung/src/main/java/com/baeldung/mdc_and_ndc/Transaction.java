package com.baeldung.mdc_and_ndc;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class Transaction {

  private String transactionId;
  private String sender;
  private Long amount;

  public Transaction(String transactionId, String sender, long amount) {
    this.transactionId = transactionId;
    this.sender = sender;
    this.amount = amount;
  }

  public String getSender() {
    return sender;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public Long getAmount() {
    return amount;
  }

  public static class TransactionFactory {
    private static final String[] NAMES = {"John", "Susan", "Marc", "Samantha"};
    private static long nextId = 1;

    public static Transaction newInstance() {
      String transactionId = String.valueOf(nextId++);
      // String transactionId = UUID.randomUUID().toString();
      String owner = NAMES[(int) floor(random() * NAMES.length)];
      long amount = (long) (random() * 1500 + 500);
      return new Transaction(transactionId, owner, amount);
    }
  }

}
