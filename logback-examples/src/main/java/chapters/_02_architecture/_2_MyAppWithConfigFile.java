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
package chapters._02_architecture;

//Import SLF4J classes.

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _2_MyAppWithConfigFile {

  private static String CONFIGURATION_LOCATION = "logback-examples-by-logback/src/main/resources/chapters/_02_architecture/sample-config-1.xml";

  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(_2_MyAppWithConfigFile.class);

    // All logging is under LoggerContext
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

    try {
      JoranConfigurator configurator = new JoranConfigurator();
      lc.reset();
      configurator.setContext(lc);
      configurator.doConfigure(CONFIGURATION_LOCATION);
    } catch (JoranException je) {
      StatusPrinter.print(lc.getStatusManager());
    }

    // Start to log
    logger.info("Entering application.");
    Bar bar = new Bar();
    bar.doIt();
    logger.info("Exiting application.");

  }
}
