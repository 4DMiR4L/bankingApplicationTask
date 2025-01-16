public class CustomerValidator {

    private String customerName;

    public CustomerValidator(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void validateCustomer() {
        if (customerName == null || customerName.length() == 0) {
            throw new InvalidCustomerException("Customer is not found");
        }
    }

    @Override
    public String toString() {
        return "CustomerValidator{" +
                "customerName='" + customerName + '\'' +
                '}';
    }
}
