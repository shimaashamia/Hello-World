package market;

public class InvoiceDetails extends Invoice {

    Item iItem;
    int quantity;

    public InvoiceDetails() {
    }

    public InvoiceDetails(Item aItem, int quantity) {
        this.iItem = aItem;
        this.quantity = quantity;
    }

    public InvoiceDetails(Item aItem, int quantity, int id, Customer aCustomer, double total_cost, double total_price, double remainder) {
        super(id, aCustomer, total_cost, total_price, remainder);
        this.iItem = aItem;
        this.quantity = quantity;
    }

    public Item getaItem() {
        return iItem;
    }

    public void setaItem(Item aItem) {
        this.iItem = aItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
