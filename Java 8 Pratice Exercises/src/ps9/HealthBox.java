package ps9;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HealthBox {
	
	  private static Map<String, LocalDateTime> appointments = new HashMap<>();
	    private static DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM);

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int option;

	        do {
	            displayMenu();
	            System.out.print("Enter an Option: ");
	            option = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (option) {
	                case 1:
	                    scheduleAppointment(scanner);
	                    break;
	                case 2:
	                    printAppointmentDetails(scanner);
	                    break;
	                case 3:
	                    rescheduleAppointment(scanner);
	                    break;
	                case 4:
	                    getReminder();
	                    break;
	                case 5:
	                    cancelAppointment(scanner);
	                    break;
	                case 6:
	                    System.out.println("Exiting the Health Box Appointment System. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid Option. Please enter a valid option.");
	            }
	        } while (option != 6);

	        scanner.close();
	    }

	    private static void displayMenu() {
	        System.out.println("\nHealth Box Appointment System Menu:");
	        System.out.println("1. Schedule an Appointment");
	        System.out.println("2. Print Appointment Details");
	        System.out.println("3. Reschedule an Appointment");
	        System.out.println("4. Get Reminder");
	        System.out.println("5. Cancel the Appointments");
	        System.out.println("6. Exit");
	    }

	    private static void scheduleAppointment(Scanner scanner) {
	        System.out.println("\nOption 1: Schedule an Appointment");
	        System.out.print("Enter Date (dd/mm/yyyy): ");
	        String date = scanner.nextLine();
	        System.out.print("Enter Time (hh:mm): ");
	        String time = scanner.nextLine();

	        System.out.println("Available Zones are:");
	        System.out.println("A: America/Anchorage\nB: Europe/Paris\nC: Asia/Tokyo\nD: America/Phoenix");
	        System.out.print("Select the Zone: ");
	        String zone = scanner.nextLine();

	        String dateTimeString = date + " " + time;
	        LocalDateTime appointmentDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

	        appointments.put(zone, appointmentDateTime);
	        System.out.println("\nSuccessfully Booked\n");
	    }

	    private static void printAppointmentDetails(Scanner scanner) {
	        System.out.println("\nOption 2: Print Appointment Details");
	        System.out.print("Enter Zone: ");
	        String zone = scanner.nextLine();

	        if (appointments.containsKey(zone)) {
	            LocalDateTime appointmentDateTime = appointments.get(zone);
	            System.out.println(appointmentDateTime.format(formatter) + " " + zone);
	        } else {
	            System.out.println("Appointment not booked for the specified zone.");
	        }
	    }

	    private static void rescheduleAppointment(Scanner scanner) {
	        System.out.println("\nOption 3: Reschedule an Appointment");
	        System.out.print("Enter Zone: ");
	        String zone = scanner.nextLine();

	        if (appointments.containsKey(zone)) {
	            LocalDateTime currentAppointmentDateTime = appointments.get(zone);
	            System.out.println("Current Appointment Date is: " + currentAppointmentDateTime.format(formatter));

	            System.out.print("Kindly Enter Number of Days to be postponed: ");
	            int days = scanner.nextInt();
	            System.out.print("Enter the new time in HH:mm: ");
	            scanner.nextLine(); // Consume newline
	            String newTime = scanner.nextLine();

	            LocalDateTime newAppointmentDateTime = currentAppointmentDateTime.plusDays(days)
	                    .withHour(Integer.parseInt(newTime.split(":")[0]))
	                    .withMinute(Integer.parseInt(newTime.split(":")[1]));

	            appointments.put(zone, newAppointmentDateTime);
	            System.out.println("Your Appointment has been rescheduled to: " + newAppointmentDateTime.format(formatter));
	        } else {
	            System.out.println("Appointment not booked for the specified zone.");
	        }
	    }

	    private static void getReminder() {
	        System.out.println("\nOption 4: Get Reminder");
	        for (Map.Entry<String, LocalDateTime> entry : appointments.entrySet()) {
	            LocalDateTime appointmentDateTime = entry.getValue();
	            LocalDateTime oneDayBefore = appointmentDateTime.minusDays(1);
	            System.out.println(oneDayBefore.format(formatter) + " " + entry.getKey());
	        }
	    }

	    private static void cancelAppointment(Scanner scanner) {
	        System.out.println("\nOption 5: Cancel the Appointments");
	        System.out.print("Enter Zone: ");
	        String zone = scanner.nextLine();

	        if (appointments.containsKey(zone)) {
	            appointments.remove(zone);
	            System.out.println("Appointment has been cancelled!!");
	        } else {
	            System.out.println("Appointment not booked for the specified zone.");
	        }
	    }
}
