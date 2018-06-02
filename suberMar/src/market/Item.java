package market;

public class Item {

    private int id;
    private String Name;
    private double Price;
    private double Cost;
    private int Quantity;

    public Item(int id, String Name, double Price, double Cost, int Quantity) {
        this.id = id;
        this.Name = Name;
        this.Price = Price;
        this.Cost = Cost;
        this.Quantity = Quantity;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
}
