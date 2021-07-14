package marker.logback.by.javacodergeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Hello world!
 */
public class App {

  private static final Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    Marker confidentialMarker = MarkerFactory.getMarker("CONFIDENTIAL");

    logger.debug("Hello world from slf4j");
    logger.debug("This logger supports confidential messages....");
    // this log is not been printed out
    logger.debug(confidentialMarker, "This is a confidential message....");
    logger.debug("Just logged a confidential message");
  }
}
