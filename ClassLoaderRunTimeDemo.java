import java.util.*;
import java.io.*;
import java.net.URLClassLoader;
import java.net.URL;
import java.lang.reflect.Method;

 
public class ClassLoaderRunTimeDemo {
   public static void main(String[] argv) {
      /* 
         testjar.jar contains a package named test with a class called TestJar.
         In TestJar class, there is an echo method that returns a String.
         We will use this to class to show how we can dynamically load a jar file at run time,
         and use the method in the class.
      */
      String testFilePath = "C:\\wamp\\cgi-bin\\java-console-scripts\\test\\testjar.jar";
      File testJarFile= new File(testFilePath);
      
      try {
         URL testJarFileURL = testJarFile.toURL();
         System.out.println(testJarFileURL);
         
         /*
            The URLClassLoader takes URL[] and ClassLoader as parameters
         */
         URLClassLoader child = new URLClassLoader(
            new URL[]{testJarFileURL}, 
            StandardOutputStreamTest.class.getClassLoader()
         );
         
         Class classToLoad = Class.forName(
            "test.TestJar", 
            true, 
            child
         );
         
         Method[] methods = classToLoad.getMethods();
         System.out.println("Display all public methods associated with TestJar.");
         for (Method method : methods) {
            System.out.println("\t" + method);
         }
         
         Object instance = classToLoad.newInstance();
         /* Note that we can not do instance.echo(), we need to call the method thru a Method object */         
         Method method = classToLoad.getMethod("echo");
         String result = (String) method.invoke(instance);
         System.out.println("From echo:\n" + method.invoke(instance));
      }
      catch(Exception e) {
         System.out.println(e);
      }
      
   }
}