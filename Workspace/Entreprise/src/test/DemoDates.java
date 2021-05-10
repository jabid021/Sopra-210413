package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DemoDates {

	public static void main(String[] args) {
		
		//Plus d'actu !
		//Date d = new Date("2021/12/24");
		
		LocalDate date2 = LocalDate.of(2021, Month.AUGUST, 18);
		
		LocalDate maDate = LocalDate.parse("2021-04-29");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("EEEE, d MMMM, yyyy");
		
		System.out.println(maDate.format(dtf));
		System.out.println(maDate.format(dtf2));
		System.out.println(maDate);
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalTime.now());
		
		
		
		System.out.println(LocalTime.now(ZoneId.of("Brazil/East")));
		maDate.plusDays(10);
		System.out.println(maDate.getDayOfWeek());
		
		
		
		
	}

}
