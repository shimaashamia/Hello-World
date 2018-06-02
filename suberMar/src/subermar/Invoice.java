package market;

public class Invoice {

    int id;
    Customer aCustomer;
    double total_cost, total_price, remainder;

    public Invoice() {
    }

    public Invoice(int id, Customer aCustomer, double total_cost, double total_price, double remainder) {
        this.id = id;
        this.aCustomer = aCustomer;
        this.total_cost = total_cost;
        this.total_price = total_price;
        this.remainder = remainder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getaCustomer() {
        return aCustomer;
    }

    public void setaCustomer(Customer aCustomer) {
        this.aCustomer = aCustomer;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public double getRemainder() {
        return remainder;
    }

    public void setRemainder(double remainder) {
        this.remainder = remainder;
    }

}
