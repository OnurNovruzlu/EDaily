package az.coftea.edaily.util;

import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class ParamValidator {
    private static final String EMAIL_PATTERN = "^([a-zA-Z0-9_+.-]+)@([a-zA-Z]+)\\.([a-zA-Z]+)$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9_.+*?!@#$%^&()=]{6,}$";

    public static boolean validateEmail(String email){
        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
        Matcher emailMatcher = emailPattern.matcher(email);
        return !emailMatcher.matches();
    }
    public static boolean validatePassword(String password){
        Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return !passwordMatcher.matches();
    }
}
