import java.util.*;
import java.io.*;

class BehavioralParameterizationUsingClass {
   public static void main(String[] argv) {
      Apple a1 = new Apple("red", 100);
      Apple a2 = new Apple("green", 110);
      Apple a3 = new Apple("red", 105);
      List<Apple> aInv = new ArrayList<Apple>(3);
      aInv.add(a1);
      aInv.add(a2);
      aInv.add(a3);
      prettyPrintApple(aInv, new AppleColorFormatter());
      prettyPrintApple(aInv, new AppleWeightFormatter());
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

interface AppleFormatter {
   public String format(Apple apple);
}

class AppleColorFormatter implements AppleFormatter {
   public String format(Apple apple) {
      return apple.getColor();
   }
}

class AppleWeightFormatter implements AppleFormatter {
   public String format(Apple apple) {
      return String.valueOf(apple.getWeight());
   }
}