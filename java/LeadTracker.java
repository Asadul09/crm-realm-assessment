import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeadTracker {

    private static final List<Lead> leads = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Simple Lead Tracker =====");
            System.out.println("1. Add a lead");
            System.out.println("2. View all leads");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addLead();
                    break;

                case "2":
                    viewLeads();
                    break;

                case "3":
                    System.out.println("Exiting Lead Tracker. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println(
                        "Invalid option. Please choose 1, 2, or 3."
                    );
            }
        }
    }

    private static void addLead() {
        System.out.print("Enter lead name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        if (!name.matches("[\\p{L}]+([ '-][\\p{L}]+)*")) {
            System.out.println(
                "Error: Name must contain letters only. Spaces, hyphens, and apostrophes are allowed between names."
            );
            return;
        }

        System.out.print("Enter lead email: ");
        String email = scanner.nextLine().trim();

        if (email.isEmpty()) {
            System.out.println("Error: Email cannot be empty.");
            return;
        }

        String emailRegex =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!email.matches(emailRegex)) {
            System.out.println(
                "Error: Please enter a valid email address (e.g., asad@gmail.com)."
            );
            return;
        }

        System.out.print("Enter lead score (0-100): ");
        String scoreInput = scanner.nextLine().trim();

        int score;

        try {
            score = Integer.parseInt(scoreInput);
        } catch (NumberFormatException e) {
            System.out.println(
                "Error: Score must be a valid integer."
            );
            return;
        }

        if (score < 0 || score > 100) {
            System.out.println(
                "Error: Score must be between 0 and 100."
            );
            return;
        }

        Lead lead = new Lead(name, email, score);
        leads.add(lead);

        System.out.println("Lead added successfully!");
    }

    private static void viewLeads() {
        if (leads.isEmpty()) {
            System.out.println(
                "No leads found. Please add a lead first."
            );
            return;
        }

        System.out.println("\n===== All Leads =====");

        for (int i = 0; i < leads.size(); i++) {
            Lead lead = leads.get(i);

            System.out.println("\nLead #" + (i + 1));
            System.out.println("Name: " + lead.getName());
            System.out.println("Email: " + lead.getEmail());
            System.out.println("Score: " + lead.getScore());
            System.out.println("Priority: " + lead.getPriority());
        }
    }
}