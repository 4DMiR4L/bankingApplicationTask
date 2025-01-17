public class CurrencyConverter {

    private double amount;
    private Currency fromCurrency;
    private Currency toCurrency;

    public CurrencyConverter(double amount, Currency fromCurrency, Currency toCurrency) {
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        //Validating inputs
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        Currency[] values = Currency.values();
        Currency fromCurrencyInCurrencyFormat = getFromCurrency();
        Currency toCurrencyInCurrencyFormat = getToCurrency();

        for (Currency value : values) {
            if (value.name().equalsIgnoreCase(fromCurrency)) {
                fromCurrencyInCurrencyFormat = value;
            }

            if (value.name().equalsIgnoreCase(toCurrency)) {
                toCurrencyInCurrencyFormat = value;
            }

        }
        if (fromCurrencyInCurrencyFormat == null || toCurrencyInCurrencyFormat == null) {
            throw new UnsupportedCurrencyException("Wrong currency format");
        }

        //Logic
        double result = 0;
        if (fromCurrencyInCurrencyFormat.cost < toCurrencyInCurrencyFormat.cost) {
            double amountInAzn = amount / fromCurrencyInCurrencyFormat.cost;
            result = amountInAzn * toCurrencyInCurrencyFormat.cost;
            System.out.println(result);
        } else {
            result = amount * toCurrencyInCurrencyFormat.cost;
            System.out.println(result);
        }
        return result;

    }

    @Override
    public String toString() {
        return "CurrencyConverter{" +
                "amount=" + amount +
                ", fromCurrency=" + fromCurrency +
                ", toCurrency=" + toCurrency +
                '}';
    }
}
