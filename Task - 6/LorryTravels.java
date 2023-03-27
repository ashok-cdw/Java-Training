
/*
 * Lorry Reach Tracker
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LorryTravels {
	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	public static void main(String[] args) {
		double speed = 50;
		double distance = 50;
		String date = "27-03-2023";
		double drivenTime = 0;

		LocalDateTime dateTime = null;
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter Speed : ");
			speed = scan.nextDouble();
			System.out.println("Enter Distance : ");
			distance = scan.nextDouble();
			System.out.println("Enter Date (dd-mm-yyyy) : ");
			date = scan.next();

			dateTime = LocalDateTime.parse(date + " 00:00", dateTimeFormatter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double reachTime = distance / speed;
		System.out.println("Time Taken : " + reachTime + " hr");

		drivenTime += 24 - dateTime.getHour() > 8 ? 8 : (24 - dateTime.getHour());

		while (drivenTime < reachTime) {

			if (!isLeaveDay(dateTime)) {
				drivenTime = drivenTime + 8;
			}
			dateTime = dateTime.plusDays(1);
		}

		System.out.println("Will Reach On : " + dateTime.getDayOfMonth() + "-" + dateTime.getMonth().getValue() + "-"
				+ dateTime.getYear());
	}

	public static boolean isLeaveDay(LocalDateTime date) {
		if (date.getMonth().getValue() == 1 && date.getDayOfMonth() == 1) {
			return true;
		} else if (date.getMonth().getValue() == 1 && date.getDayOfMonth() == 26) {
			return true;
		} else if (date.getMonth().getValue() == 8 && date.getDayOfMonth() == 15) {
			return true;
		} else if (date.getDayOfWeek().getValue() == 7) {
			return true;
		} else if (date.getDayOfWeek().getValue() == 6 && date.getDayOfMonth() >= 8) {
			return true;
		}
		return false;
	}
}
