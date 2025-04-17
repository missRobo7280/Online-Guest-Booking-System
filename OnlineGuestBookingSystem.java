import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ReservationSystem {
    private Map<String, Boolean> roomAvailability;

    public ReservationSystem(int numberOfRooms) {
        roomAvailability = new HashMap<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            roomAvailability.put("Room" + i, true);
        }
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Map.Entry<String, Boolean> entry : roomAvailability.entrySet()) {
            if (entry.getValue()) {
                System.out.println(entry.getKey());
            }
        }
        System.out.println();
    }

    public void makeReservation(String roomName) {
        if (roomAvailability.containsKey(roomName) && roomAvailability.get(roomName)) {
            roomAvailability.put(roomName, false);
            System.out.println("Reservation successful for " + roomName);
        } else {
            System.out.println("Room " + roomName + " is not available for reservation.");
        }
    }
}
class OnlineGuestBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rooms: ");
        int numberOfRooms = scanner.nextInt();

        ReservationSystem reservationSystem = new ReservationSystem(numberOfRooms);

        while (true) {
            System.out.println("1. Display available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reservationSystem.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter the room name to reserve: ");
                    String roomName = scanner.nextLine();
                    reservationSystem.makeReservation(roomName);
                    break;
                case 3:
                    System.out.println("Exiting the reservation system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
