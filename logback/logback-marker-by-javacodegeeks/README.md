# MDC & Marker

SLF4J定义了MDC适配器接口org.slf4j.spi.MDCAdapter，每一种日志框架，都有对应的MDC桥接，Log4jMDCAdapter是Log4j的一种MDCAdapter适配器实现，具体是转发到 org.apache.log4j.MDC来处理的。接口如下：

```java
public interface MDCAdapter {
  public void put(String key, String val);
  public String get(String key);
  public void remove(String key);
  public void clear();
  public Map getCopyOfContextMap();
  public void setContextMap(Map contextMap);
}
```

SLF4J增加了`Marker`，Marker是有名字属性的对象，用来**丰富日志日志功能**，有具体的日志框架决定Marker信息具体如何处理，并且多个Marker直接可以有引用父子关系。但是**目前只有logback对其进行了实现**，其他日志框架都是忽略Marker信息。Marker系列和Logger、LoggerFactory系列原理也是高度一致的，涉及的类有：

```java
org.slf4j.Marker
org.slf4j.helpers.BasicMarker
org.slf4j.MarkerFactory
org.slf4j.IMarkerFactory
org.slf4j.spi.MarkerFactoryBinder
org.slf4j.helpers.BasicMarkerFactory
org.slf4j.impl.StaticMarkerBinder
```

- <https://examples.javacodegeeks.com/enterprise-java/slf4j/slf4j-markers-example/>

For this example, we will be using logback as logger with SLF4J. Logback was conceived and created as a successor to Log4J. Logback supports markers for the logging calls. These Markers allow association of tags with log statements. These tags enable various appenders to take decision on basis of their presence and absence. For the purposes of this example, we will be associating a ‘confidential’ tag which filter certain log statements on basis of what they are marked with.

# What are markers in Java Logging frameworks and what is a reason to use them?

- <https://stackoverflow.com/questions/16813032/what-are-markers-in-java-logging-frameworks-and-what-is-a-reason-to-use-them>

This is a rehashed version my answer<https://stackoverflow.com/a/10231016/100970> to the question "Best practices for using Markers in SLF4J/Logback"<https://stackoverflow.com/q/4165558/100970>.

Markers can be used to color or mark a single log statement. What you do with these colors, i.e. markers, is entirely up to you. However, two patterns seem to be common (the first more common than the second) for marker usage.

- **Triggering**: Some appender could be instructed to take an action in the presence of a certain marker. For example, SMTPAppender can be configured to send an email whenever a logging event is marked with the NOTIFY_ADMIN marker regardless of the log level. See marker-based triggering <http://logback.qos.ch/manual/appenders.html#OnMarkerEvaluator> in the logback documentation. You may also combine log levels and markers for triggering.
- **Filtering**: You could for example color/mark all your persistence related logs (in various and multiple class files) with the color "DB". You could then filter for "DB": disable logging except for log statements marked with DB. See the chapter on filters <http://logback.qos.ch/manual/filters.html> in the logback documentation for more information (search for MarkerFilter).

# MDC - Mapped Diagnostic Context

The basic idea of Mapped Diagnostic Context is to provide a way to enrich log messages with pieces of information that could be not available in the scope where the logging actually occurs, but that can be indeed useful to better track the execution of the program.
- <https://www.baeldung.com/mdc-in-log4j-2-logback>
