package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helpers {

    public static boolean isValidDate(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        try {
            df.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
