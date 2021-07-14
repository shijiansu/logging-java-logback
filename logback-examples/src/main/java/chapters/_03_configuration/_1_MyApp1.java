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
package chapters._03_configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _1_MyApp1 {

  private static String CONFIGURATION_LOCATION = "logback-examples-by-logback/src/main/resources/chapters/_03_configuration/sample0.xml";

  static {
    System.setProperty("logback.configurationFile", CONFIGURATION_LOCATION);
  }

  final static Logger logger = LoggerFactory.getLogger(_1_MyApp1.class);

  public static void main(String[] args) {
    // Print
    // LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    // StatusPrinter.print(lc);

    logger.info("Entering application.");
    Foo foo = new Foo();
    foo.doIt();
    logger.info("Exiting application.");
  }
}
