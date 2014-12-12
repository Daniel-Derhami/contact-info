package exceptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by shahriar on 12/12/14.
 */
public class UserInfoException extends RuntimeException {
    private Exception origException;
    private String date;
    private String time;
    private ErrorCode errorCode;
    public UserInfoException(Exception origException,ErrorCode errorCode){
        setOrigException(origException);
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat tf = new SimpleDateFormat("HH:mm:ss");
        setDate(df.format(cal.getTime()));
        setTime(tf.format(cal.getTime()));
        this.setErrorCode(errorCode);
    }
    public Exception getOrigException() {
        return origException;
    }

    public void setOrigException(Exception origException) {
        this.origException = origException;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
