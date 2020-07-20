/**
 * Logback: the reliable, generic, fast and flexible logging framework. Copyright (C) 1999-2015,
 * QOS.ch. All rights reserved.
 * <p>
 * This program and the accompanying materials are dual-licensed under either the terms of the
 * Eclipse Public License v1.0 as published by the Eclipse Foundation
 * <p>
 * or (per the licensee's choosing)
 * <p>
 * under the terms of the GNU Lesser General Public License version 2.1 as published by the Free
 * Software Foundation.
 */
package chapters._08_mdc;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.StatusPrinter;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class _1_MdcByXml {

    static public void main(String[] args) throws Exception {
        // You can put values in the MDC at any time. Before anything else
        // we put the first name
        MDC.put("first", "Dorothy");

        // configure via the configuration file "chapters/mdc/mdc.xml"
        // which ships with the examples
        configureViaXML_File();

        Logger logger = LoggerFactory.getLogger(_1_MdcByXml.class);
        // We now put the last name
        MDC.put("last", "Parker");

        // The most beautiful two words in the English language according
        // to Dorothy Parker:
        logger.info("Check enclosed.");
        logger.debug("The most beautiful two words in English.");

        MDC.put("first", "Richard");
        MDC.put("last", "Nixon");
        logger.info("I am not a crook.");
        logger.info("Attributed to the former US president. 17 Nov 1973.");
    }

    private static void configureViaXML_File() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(lc);
            lc.reset();
            URL url = Loader.getResourceBySelfClassLoader("chapters/_08_mdc/mdc.xml");
            configurator.doConfigure(url);
        } catch (JoranException je) {
            StatusPrinter.print(lc);
        }
    }

}
