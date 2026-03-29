import java.util.Scanner;

public class Main {
    static UserLoginSystem login = new UserLoginSystem();
    static Train train = new Train(101, "Express Train", "Delhi", "Mumbai");
    static Scanner sc = new Scanner(System.in);
    static int ticketId = 1001, passId = 1, payId = 1;

    public static void main(String[] args) {
        System.out.println("===== TRAIN TICKET SYSTEM =====");
        while (true) {
            if (!login.isLoggedIn()) {
                authMenu();
            } else {
                mainMenu();
            }
        }
    }

    static void authMenu() {
        System.out.println("\n1. Login  2. Register  3. Exit");
        System.out.print("Choice: ");
        String ch = sc.nextLine();
        if (ch.equals("1")) {
            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();
            if (login.login(u, p)) System.out.println("✓ Login OK");
            else System.out.println("✗ Failed");
        } else if (ch.equals("2")) {
            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();
            if (login.register(u, p)) System.out.println("✓ Registered");
            else System.out.println("✗ Exists");
        } else System.exit(0);
    }

    static void mainMenu() {
        System.out.println("\n1. Book  2. Cancel  3. View Passengers  4. Status  5. Logout");
        System.out.print("Choice: ");
        String ch = sc.nextLine();
        if (ch.equals("1")) book();
        else if (ch.equals("2")) cancel();
        else if (ch.equals("3")) showPassengers();
        else if (ch.equals("4")) status();
        else if (ch.equals("5")) logout();
    }

    static void book() {
        if (!train.hasCapacity()) {
            System.out.println("✗ Train Full");
            return;
        }
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Aadhar: ");
        String aadhar = sc.nextLine();
        System.out.print("Fare: ");
        double fare = Double.parseDouble(sc.nextLine());

        Passenger p = new Passenger(passId++, name, age, aadhar);
        Payment pay = new Payment(payId++, fare, "UPI", "COMPLETED");
        Ticket t = new Ticket(ticketId++, train.getTrainNumber(), train.getSource(), 
                             train.getDestination(), fare, "BOOKED", pay);
        p.addTicket(t);
        train.addPassenger(p);
        System.out.println("✓ Booked | Seats Left: " + train.getAvailableSeats());
    }

    static void cancel() {
        System.out.print("Passenger ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Passenger p = findPassenger(id);
        if (p == null) {
            System.out.println("✗ Not Found");
            return;
        }
        if (!p.getTickets().isEmpty()) {
            Ticket t = p.getTickets().get(0);
            p.removeTicket(t);
            train.removePassenger(p);
            System.out.println("✓ Cancelled | Refund: " + t.getFare());
        }
    }

    static void showPassengers() {
        System.out.println("\n=== PASSENGERS ===");
        if (train.getPassengers().isEmpty()) {
            System.out.println("None");
            return;
        }
        for (Passenger p : train.getPassengers()) {
            System.out.println("ID=" + p.getId() + " | " + p.getName() + " | Age=" + p.getAge());
        }
    }

    static void status() {
        System.out.println("\n=== TRAIN STATUS ===");
        System.out.println("Total: " + train.getTotalCapacity() + " | Occupied: " + 
                          train.getCurrentPassengers() + " | Available: " + train.getAvailableSeats());
    }

    static void logout() {
        login.logout();
        System.out.println("✓ Logged Out");
    }

    static Passenger findPassenger(int id) {
        for (Passenger p : train.getPassengers()) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}
