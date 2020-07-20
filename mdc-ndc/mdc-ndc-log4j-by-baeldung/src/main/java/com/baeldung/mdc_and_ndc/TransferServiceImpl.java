package com.baeldung.mdc_and_ndc;

import org.apache.log4j.Logger;

public class TransferServiceImpl extends TransferService {

  private Logger LOGGER = Logger.getLogger(TransferServiceImpl.class);

  @Override
  protected void beforeTransfer(long amount) {
    LOGGER.info("Preparing to transfer " + amount + "$.");
  }

  @Override
  protected void afterTransfer(long amount, boolean outcome) {
    LOGGER.info("Has transfer of " + amount + "$ completed successfully ? " + outcome + ".");
  }

}