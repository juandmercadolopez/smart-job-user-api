package cl.bci.user.constant;

import org.springframework.beans.factory.annotation.Value;

public class RegexConstant {

    @Value("${regex.phone}")
    public static String PHONE_REGEX;

    @Value("${regex.email}")
    public static String EMAIL_REGEX;

}
