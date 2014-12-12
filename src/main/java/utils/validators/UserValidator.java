package utils.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shahriar on 12/12/14.
 */
public class UserValidator {



    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public UserValidator() {
    }

    public static boolean validateEmail(final String inputEmail) {

        Matcher matcher = pattern.matcher(inputEmail);
        return matcher.matches();

    }
}
