package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomGenerator {

    public static final String UNIQUE_ID_FORMAT = "yy-MM-dd-HH-mm-ss";

    public static synchronized String getUniqueId() {
        return new SimpleDateFormat(UNIQUE_ID_FORMAT).format(new Date());
    }
}
