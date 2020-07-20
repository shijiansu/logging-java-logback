package com.baeldung.mdc_and_ndc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class TransferServiceImpl extends TransferService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TransferServiceImpl.class);

  @Override
  protected void beforeTransfer(long amount) {
    LOGGER.info("Preparing to transfer {}$.", amount);
  }

  @Override
  protected void afterTransfer(long amount, boolean outcome) {
    LOGGER.info("Has transfer of {}$ completed successfully ? {}.", amount, outcome);
  }

}