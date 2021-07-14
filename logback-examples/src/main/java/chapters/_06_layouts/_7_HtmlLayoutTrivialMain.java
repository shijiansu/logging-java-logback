/**
 * Logback: the reliable, generic, fast and flexible logging framework. Copyright (C) 1999-2015,
 * QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under either the terms of the
 * Eclipse Public License v1.0 as published by the Eclipse Foundation
 *
 * or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1 as published by the Free
 * Software Foundation.
 */
package chapters._06_layouts;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _7_HtmlLayoutTrivialMain {

  private static String CONFIGURATION_LOCATION
      = "logback-examples-by-logback/src/main/resources/chapters/_06_layouts/htmlLayout.xml";

  public static void main(String[] args) throws InterruptedException, JoranException {
    Logger logger = LoggerFactory.getLogger(_7_HtmlLayoutTrivialMain.class);
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    JoranConfigurator configurator = new JoranConfigurator();
    configurator.setContext(lc);
    lc.reset();
    configurator.doConfigure(CONFIGURATION_LOCATION);
    StatusPrinter.printInCaseOfErrorsOrWarnings(lc);

    for (int i = 0; i < 6; i++) {
      if (i % 5 == 0) {
        logger.warn("a warning message " + i);
      } else if (i % 3 == 0) {
        logger.info("hello world number" + i);
      } else {
        logger.debug("hello world number" + i);
      }
    }
    logger.error("Finish off with fireworks", new Exception("Just testing"));
  }
}