
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

		LocalDateTime localDateTime = null;
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter Speed : ");
			speed = scan.nextDouble();
			System.out.println("Enter Distance : ");
			distance = scan.nextDouble();
			System.out.println("Enter Date (dd-mm-yyyy) : ");
			date = scan.next();
			localDateTime = LocalDateTime.parse(date + " 00:00", dateTimeFormatter);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			date = "27-03-2023";
			System.out.println("Fallback Date Setted : " + date);
			localDateTime = LocalDateTime.parse(date + " 00:00", dateTimeFormatter);
		}
		double reachTime = distance / speed;
		System.out.println("Time Taken : " + reachTime + " hr");

		drivenTime += 24 - localDateTime.getHour() > 8 ? 8 : (24 - localDateTime.getHour());
		while (drivenTime < reachTime) {
			if (!isLeaveDay(localDateTime)) {
				drivenTime = drivenTime + 8;
			}
			localDateTime = localDateTime.plusDays(1);
		}

		System.out.println("Will Reach On : " + localDateTime.getDayOfMonth() + "-"
				+ localDateTime.getMonth().getValue() + "-" + localDateTime.getYear());
	}

	public static boolean isLeaveDay(LocalDateTime localDateTime) {
		if (localDateTime.getMonth().getValue() == 1 && localDateTime.getDayOfMonth() == 1) {
			return true;
		} else if (localDateTime.getMonth().getValue() == 1 && localDateTime.getDayOfMonth() == 26) {
			return true;
		} else if (localDateTime.getMonth().getValue() == 8 && localDateTime.getDayOfMonth() == 15) {
			return true;
		} else if (localDateTime.getDayOfWeek().getValue() == 7) {
			return true;
		} else if (localDateTime.getDayOfWeek().getValue() == 6 && localDateTime.getDayOfMonth() >= 8) {
			return true;
		}
		return false;
	}
}
