package config;

public class Properties {
	public final long STAY_TIME_ERROR = 3000;
	public final long STAY_TIME = 8000;
	public final long STAY_TIME_DELAY = 1000;
	public final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public final String MOBILE_PATTERN = "^\\+?[0-9]{10}$";
	public final String PAN_PATTERN = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
	public final String PASSWORD_PATTERN =
            "^(?=.*[0-9])" +           // at least one digit
            "(?=.*[a-z])" +            // at least one lowercase letter
            "(?=.*[A-Z])" +            // at least one uppercase letter
            "(?=.*[@#$%^&+=])" +       // at least one special character
            "(?=\\S+$)" +              // no whitespace
            ".{8,20}$";                // length between 8 and 20 characters
	
	public final String EMAIL_PATTERN =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" + // local part
            "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";         // domain part
	
}