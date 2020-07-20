package com.baeldung.mdc_and_ndc;

import com.baeldung.mdc_and_ndc.TransferService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransferServiceImpl extends TransferService {

  private static final Logger LOGGER = LogManager.getLogger();

  @Override
  protected void beforeTransfer(long amount) {
    LOGGER.info("Preparing to transfer {}$.", amount);
  }

  @Override
  protected void afterTransfer(long amount, boolean outcome) {
    LOGGER.info("Has transfer of {}$ completed successfully ? {}.", amount, outcome);
  }

}