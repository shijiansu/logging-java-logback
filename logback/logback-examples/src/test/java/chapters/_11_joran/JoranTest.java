package chapters._11_joran;

import chapters._11_joran._1_helloWorld.HelloWorld;
import chapters._11_joran._2_calculator.Calculator1;
import chapters._11_joran._3_implicit.PrintMe;
import chapters._11_joran._4_newRule.NewRuleCalculator;
import org.junit.jupiter.api.Test;

public class JoranTest {

  @Test
  void hello() throws Exception {
    HelloWorld.main(new String[]{
        "src/main/resources/chapters/_11_joran/_1_helloWorld/hello.xml"});
  }

  @Test
  void calculator1() throws Exception {
    Calculator1.main(new String[]{
        "src/main/resources/chapters/_11_joran/_2_calculator/calculator1.xml"});
  }

  @Test
  void calculator2() throws Exception {
    Calculator1.main(new String[]{
        "src/main/resources/chapters/_11_joran/_2_calculator/calculator2.xml"});
  }

  @Test
  void implicit1() throws Exception {
    PrintMe.main(new String[]{
        "src/main/resources/chapters/_11_joran/_3_implicit/implicit1.xml"});
  }

  @Test
  void newRule() throws Exception {
    NewRuleCalculator.main(new String[]{
        "src/main/resources/chapters/_11_joran/_4_newRule/newRule.xml"});
  }
}
