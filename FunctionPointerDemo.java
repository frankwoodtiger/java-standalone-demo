/* 
   In Java, one might simulate the use of function pointer by
   the use of anonymous inner class and interface. This is the
   technique use before Java 8 though
*/


public class FunctionPointerDemo {
   public void takingMethod(StringFunction sf) {
      int output = sf.somefunction(99);
      System.out.println(output);
   }
   
   public static void main(String[] argv) {
      FunctionPointerDemo ref = new FunctionPointerDemo();
      ref.takingMethod(new StringFunction() {
         public int somefunction(int param) {
            return param;
         }
      });
   }
}

interface StringFunction {
    int somefunction(int param);
}