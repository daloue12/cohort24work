package learn.solar.data;

import java.io.IOException;
public class DataException extends IOException {

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}
