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
package chapters._11_joran._1_helloWorld;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.xml.sax.Attributes;

/**
 * A trivial action that writes "Hello world" on the console.
 *
 * See the {@link HelloWorld} class for integration with Joran.
 *
 * @author Ceki G&uuml;lc&uuml;
 */
public class HelloWorldAction extends Action {

  public void begin(InterpretationContext ec, String name, Attributes attributes) {
    System.out.println("Hello World");
  }

  public void end(InterpretationContext ec, String name) {
  }
}