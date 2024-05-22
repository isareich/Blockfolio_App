import java.util.Date;

public class Transaction {
    private String cryptoCurrency;
    private double quantity;
    private double exchangeRate;
    private Date transactionDate;
    private TransactionType transactionType;

    // Constructor to initialize the Transaction object
    public Transaction(String cryptoCurrency, double quantity, double exchangeRate, Date transactionDate, TransactionType transactionType) {
        this.cryptoCurrency = cryptoCurrency;
        this.quantity = quantity;
        this.exchangeRate = exchangeRate;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }
    // Getters and setters for each field
    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    // Overriding toString() method to provide a string representation of the transaction
    @Override
    public String toString() {
        return "Transaction {" +
                "CryptoCurrency='" + cryptoCurrency + '\'' +
                ", Quantity=" + quantity +
                ", ExchangeRate=" + exchangeRate +
                ", TransactionDate=" + transactionDate +
                ", TransactionType=" + transactionType +
                '}';
    }
}
