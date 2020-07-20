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
package chapters._04_appenders.customized_appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;

public class CountingConsoleAppender extends AppenderBase<ILoggingEvent> {

  static int DEFAULT_LIMIT = 10;
  int counter = 0;
  int limit = DEFAULT_LIMIT;

  Layout<ILoggingEvent> layout;

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  @Override
  public void start() {
    if (this.layout == null) {
      addError("No layout set for the appender named [" + name + "].");
      return;
    }
    String header = layout.getFileHeader();
    if(header == null){
      header = "No header setup!";
    }
    System.out.println(header);
    super.start();
  }

  @Override
  public void append(ILoggingEvent event) {
    if (counter >= limit) {
      return;
    }
    // output the events as formatted by patternLayout
    String eventStr = this.layout.doLayout(event);
    System.out.print(eventStr);
    // prepare for next event
    counter++;
  }

  public Layout<ILoggingEvent> getLayout() {
    return layout;
  }

  public void setLayout(Layout<ILoggingEvent> layout) {
    this.layout = layout;
  }
}
