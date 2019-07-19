package BBC.Weather;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

	public static String FormatedDate(String formatIn,int days){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatIn);
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate.plusDays(days));
	}
}
