package com.baeldung.mdc_and_ndc;

import com.lambdista.util.Try;

/**
 * A fake transfer service simulating an actual one.
 */
public abstract class TransferService {

  /**
   * Sample service transferring a given amount of money.
   *
   * @return {@code true} when the transfer complete successfully, {@code false} otherwise.
   */
  public boolean transfer(long amount) {
    beforeTransfer(amount);
    // exchange messages with a remote system to transfer the money
    return Try.apply(() -> {
          Thread.sleep((long) (500 + Math.random() * 500));
          boolean outcome = Math.random() >= 0.25;
          afterTransfer(amount, outcome);
          return outcome;
        }
    ).map(outcome -> outcome).get();
  }

  /**
   * For different logger implementation - by command pattern
   */
  abstract protected void beforeTransfer(long amount);

  /**
   * For different logger implementation - by command pattern
   */
  abstract protected void afterTransfer(long amount, boolean outcome);
}
