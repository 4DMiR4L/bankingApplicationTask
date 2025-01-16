public class Main {
    public static void main(String[] args) {

        CustomerValidator customer = new CustomerValidator("Murad");
        BankAccount account = new BankAccount("4567", 125.0);

        CurrencyConverter converter = new CurrencyConverter(170, Currency.USD, Currency.EUR);
        double returned = converter.convert(170, "USD", "EUR");
        System.out.println(returned);
        System.out.println(converter);
    }
}
