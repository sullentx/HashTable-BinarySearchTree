import models.Business;
import models.HashTableMe;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private HashTableMe hashTable;
    public static void main(String[] args) {
        Main app = new Main(1000);
        app.loadBusinessesFromCSV("bussines.csv");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a business");
            System.out.println("2. Search for a business by ID");
            System.out.println("3. Display all businesses");
            System.out.println("4. Exit");
            int aux = scanner.nextInt();
            scanner.nextLine();
            switch (aux) {
                case 1:
                    System.out.print("Enter business ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter business name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter business address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter business city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter business state: ");
                    String state = scanner.nextLine();
                    long startTimeAdd = System.currentTimeMillis();
                    app.addBusiness(id, name, address, city, state);
                    long endTimeAdd = System.currentTimeMillis();
                    System.out.println("Execution time: " + (endTimeAdd - startTimeAdd) / 1000.0 + " seconds");
                    break;
                case 2:
                    System.out.print("Enter business ID to search: ");
                    String searchId = scanner.nextLine();
                    long startTimeSearch = System.currentTimeMillis();
                    app.searchBusinessById(searchId);
                    long endTimeSearch = System.currentTimeMillis();
                    System.out.println("Execution time: " + (endTimeSearch - startTimeSearch) / 1000.0 + " seconds");
                    break;
                case 3:
                    long startTimeDisplay = System.currentTimeMillis();
                    app.displayAllBusinesses();
                    long endTimeDisplay = System.currentTimeMillis();
                    System.out.println("Execution time: " + (endTimeDisplay - startTimeDisplay) / 1000.0 + " seconds");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public Main(int tableSize) {
        hashTable = new HashTableMe(tableSize);
    }

    public void loadBusinessesFromCSV(String fileName) {
        String line;
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] businessData = line.split(splitBy);
                Business business = new Business(businessData[0], businessData[1], businessData[2], businessData[3], businessData[4]);
                hashTable.put(business.getId(), business);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBusiness(String id, String name, String address, String city, String state) {
        Business business = new Business(id, name, address, city, state);
        hashTable.put(id, business);
        System.out.println("Business added successfully.");
    }

    public void searchBusinessById(String id) {
        Business foundBusiness = hashTable.get(id);
        if (foundBusiness != null) {
            System.out.println("Found business: " + foundBusiness);
        } else {
            System.out.println("Business not found.");
        }
    }
    public void displayAllBusinesses() {
        List<Business> businesses = hashTable.getAllBusinesses();
        for (Business business : businesses) {
            System.out.println(business);
        }
    }
}

