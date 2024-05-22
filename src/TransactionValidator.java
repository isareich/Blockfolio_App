public class TransactionValidator {
    // Method to validate a transaction
    public void validate(Transaction transaction) throws InvalidTransactionException {
        if (transaction == null) {
            throw new InvalidTransactionException("Transaction cannot be null.");
        }
        if (transaction.getCryptoCurrency() == null || transaction.getCryptoCurrency().isEmpty()) {
            throw new InvalidTransactionException("Cryptocurrency name is required.");
        }
        if (transaction.getQuantity() <= 0) {
            throw new InvalidTransactionException("Quantity must be greater than 0.");
        }
        if (transaction.getExchangeRate() <= 0) {
            throw new InvalidTransactionException("Exchange rate must be greater than 0.");
        }
    }
}