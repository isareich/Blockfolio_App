import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionValidator validator = new TransactionValidator();

        System.out.println("Welcome to the CryptoCurrency Transaction Tracker!");

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add new transaction");
            System.out.println("2. Load transaction history");
            System.out.println("3. Exit");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addNewTransaction(scanner, validator);
                    break;
                case "2":
                    loadTransactionHistory();
                    break;
                case "3":
                    System.out.println("Thank you for using the CryptoCurrency Transaction Tracker!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

    private static void addNewTransaction(Scanner scanner, TransactionValidator validator) {
        try {
            System.out.println("Enter transaction type (DEBIT/CREDIT): ");
            String typeInput = scanner.nextLine().toUpperCase();
            TransactionType type = TransactionType.valueOf(typeInput);

            System.out.println("Enter the cryptocurrency name: ");
            String currency = scanner.nextLine();

            System.out.println("Enter the quantity of the cryptocurrency: ");
            double quantity = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter the exchange rate: ");
            double exchangeRate = Double.parseDouble(scanner.nextLine());

            // Getting today's date for simplicity
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = sdf.format(new Date());
            Date transactionDate = sdf.parse(dateString);

            // Creating a transaction object
            Transaction transaction = new Transaction(currency, quantity, exchangeRate, transactionDate, type);

            // Validate the transaction using the validator
            validator.validate(transaction);
            transactions.add(transaction);
            System.out.println("Transaction added successfully.");
            System.out.println(transaction);

        } catch (InvalidTransactionException e) {
            // Handling the custom exception
            System.out.println("Validation error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input for transaction type. Please enter either 'DEBIT' or 'CREDIT'.");
        } catch (Exception e) {
            // Handling other unexpected exceptions
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please try again.");
        }
    }

    private static void loadTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            double totalDebit = 0;
            double totalCredit = 0;

            System.out.println("Transaction history:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
                if (transaction.getTransactionType() == TransactionType.DEBIT) {
                    totalDebit += transaction.getQuantity() * transaction.getExchangeRate();
                } else if (transaction.getTransactionType() == TransactionType.CREDIT) {
                    totalCredit += transaction.getQuantity() * transaction.getExchangeRate();
                }
            }

            System.out.println("Total Debit: " + totalDebit);
            System.out.println("Total Credit: " + totalCredit);
        }
    }
}
