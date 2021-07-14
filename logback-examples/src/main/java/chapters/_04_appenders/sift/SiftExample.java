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
package chapters._04_appenders.sift;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class SiftExample {

  private static String CONFIGURATION_LOCATION = "logback-examples-by-logback/src/main/resources/chapters/_04_appenders/sift/byUserid.xml"; //

  public static void main(String[] args) throws JoranException {
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    lc.reset();

    JoranConfigurator configurator = new JoranConfigurator();
    configurator.setContext(lc);
    configurator.doConfigure(CONFIGURATION_LOCATION);

    Logger logger = LoggerFactory.getLogger(SiftExample.class);
    logger.debug("Application started");

    MDC.put("userid", "Alice");
    logger.debug("Alice says hello");

    StatusPrinter.print(lc);
  }

  static void usage(String msg) {
    System.err.println(msg);
    System.err.println("Usage: java " + SiftExample.class.getName() + " configFile\n"
        + "   configFile a logback configuration file");
    System.exit(1);
  }
}
