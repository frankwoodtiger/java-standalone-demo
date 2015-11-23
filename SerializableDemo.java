import java.io.*;
public class SerializableDemo {
   public static void main(String[] argv) {
      Employee emp = new Employee("Chi", "00001");
      System.out.println("Before serialized: " + emp);

      /* ---------- Serializing Employee ------------- */
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream oos;
      ObjectOutputStream oosToStdout;
      try {
         System.out.print("Serialized raw byte: ");
	     oosToStdout = new ObjectOutputStream(System.out);
	     oosToStdout.writeObject(emp); // Write to stdout to display the raw string
	 
	     oos = new ObjectOutputStream(bos);
	     oos.writeObject(emp);
      }
      catch (Exception e) {
	     System.out.println(e);
      }
      /* ------------ Serializing End ----------------*/
      
      /* ---------- Deserializing Employee ------------- */
      try {
         ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());      
         ObjectInputStream ois = new ObjectInputStream(bis);
         Employee deserializedEmp = (Employee) ois.readObject();
         System.out.println("\nDeserialized Employee " + deserializedEmp);
      }
      catch(Exception e) {
         System.out.println(e);
      }
      /* ------------ Serializing End ----------------*/
  }
}

class Employee implements Serializable {
   private String name;
   private String id;
   
   public Employee(String name, String id) {
      this.name = name;
      this.id = id;
   }
   
   public String toString() {
      return name + " -> " + id;
   }
}