import java.util.Calendar;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

/* Class that demonstrate the correct use of date time utility in Java */
public class DateFormatDemo {
   public static void main(String[] argv) {
      /* Print all available timezone id */
      for(String timezoneId : TimeZone.getAvailableIDs()) {
         System.out.print(timezoneId + " ");
      }
      System.out.println();
      /* Get EST timestamp */
      System.out.println(getTimestamp("EST"));
      /* Get GMT timestamp */
      System.out.println(getTimestamp("GMT"));
   }
   
   /* Return timestamp in ISO 8601 format */
   public static String getTimestamp(String timezone) {
      Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      sdf.setTimeZone(TimeZone.getTimeZone(timezone));
      return sdf.format(cal.getTime()).toString().replace(' ', 'T');
   }
}