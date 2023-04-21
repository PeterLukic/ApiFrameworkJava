package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helpers {

    public static boolean isValidDate(String dateFormat, String dateString) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        try {
            df.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
