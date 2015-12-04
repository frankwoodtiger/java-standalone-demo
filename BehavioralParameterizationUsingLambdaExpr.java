import java.util.*;
import java.io.*;

class BehavioralParameterizationUsingLambdaExpr {
   public static void main(String[] argv) {
      Apple a1 = new Apple("red", 100);
      Apple a2 = new Apple("green", 110);
      Apple a3 = new Apple("red", 105);
      List<Apple> aInv = new ArrayList<Apple>(3);
      aInv.add(a1);
      aInv.add(a2);
      aInv.add(a3);
      prettyPrintApple(aInv, (Apple apple) -> apple.getColor());
      prettyPrintApple(aInv, (Apple apple) -> String.valueOf(apple.getWeight()));
   }
   
   public static void prettyPrintApple(List<Apple> inventory, AppleFormatter af) {
      StringBuilder sb = new StringBuilder();
      String delimiter = "";
      for(Apple apple : inventory) {
         sb.append(delimiter + af.format(apple));
         delimiter = " -> ";
      }
      System.out.println(sb);
   }
}

class Apple {
   private String color;
   private int weight;
   
   public Apple(String color, int weight) {
      this.color = color;
      this.weight = weight;
   }
   
   public String getColor() {
      return this.color;
   }
   
   public int getWeight() {
      return this.weight;
   }
}

/* 
   Annotation is optional but good practice to signify the interface is
   a functional interface (interface with exactly one abstract method).
   Functional interface is required for the use of lambda expression in
   Java
*/   
@FunctionalInterface
interface AppleFormatter {
   public String format(Apple apple);
}