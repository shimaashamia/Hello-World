/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subermar;

import java.util.ArrayList;
import java.util.Scanner;
import market.Customer;
import market.InvoiceDetails;
import market.Item;

/**
 *
 * @author Shimaa
 */
public class SuberMar {
static int item_id = 1;
    static int invoice_id = 1;
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Customer> customer = new ArrayList<>();
    static ArrayList<InvoiceDetails> invoice = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    private static Object customers;
    public static void main(String[] args) {
        
         String username = "shimaa.shamia";
        String password = "123sh";
        String user, pass;
        System.out.println("Welcome to the system");
        System.out.println(" -LOGING- ");
        int i = 0;
        do {
            if (i != 0) {
                System.out.println("- Error -");
            }
            System.out.println("Please enter your username:");
            user = in.next();
            System.out.println("Please enter your password:");
            pass = in.next();
            i++;
        } while (!username.equalsIgnoreCase(user) && !password.equalsIgnoreCase(pass));
        menu();
    }

    public static void menu() {
        int number;
        System.out.println("1- Add an Item to Inventory");
        System.out.println("2- Update Item information");
        System.out.println("3- Search for Item");
        System.out.println("4- Delete an Item");
        System.out.println("5- Add a New Customer");
        System.out.println("6- View all items");
        System.out.println("7- Sell an Item");
        System.out.println("8- View Daily Movement");
        System.out.println("9- View Daily Report");
        System.out.println("10- View Invoice Details by ID");
        System.out.println("11- Pay a Previous Invoice");
        System.out.println("12- Exit");
        do {
            System.out.println("Enter your number:");
            number = in.nextInt();
            switch (number) {
                case 1:
                    System.out.println("===");
                    addItem();
                    System.out.println("===");
                    menu();
                    break;
                case 2:
                    System.out.println("===");
                    editItem();
                    System.out.println("===");
                    menu();
                    break;
                case 3:
                    System.out.println("===");
                    searchItem();
                    System.out.println("===");
                    menu();
                    break;
                case 4:
                    System.out.println("===");
                    deleteItem();
                    System.out.println("===");
                    menu();
                    break;
                case 5:
                    System.out.println("===");
                    addCustomer();
                    System.out.println("===");
                    menu();
                    break;
                case 6:
                    System.out.println("===");
                    viewAllItem();
                    System.out.println("===");
                    menu();
                    break;
                case 7:
                    System.out.println("===");
                    sellAnItem();
                    System.out.println("===");
                    menu();
                    break;
                case 8:
                    System.out.println("===");
                    viewInvoices();
                    System.out.println("===");
                    menu();
                    break;
                case 9:
                    System.out.println("===");
                    viewProfits();
                    System.out.println("===");
                    menu();
                    break;
                case 10:
                    System.out.println("===");
                    viewInvoiceById();
                    System.out.println("===");
                    menu();
                    break;
                case 11:
                    System.out.println("===");
                    viewInvoicesReminder();
                    System.out.println("===");
                    menu();

                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("--------- Error --------");
                    break;
            }

        } while (true);
    }

    public static void addItem() {
        int id = item_id;
        item_id++;
        String item_name;
        double item_price,
                item_cost;
        int item_quantity;
        System.out.println("Please enter item name:");
        item_name = in.next();
        System.out.println("Please enter item price:");
        item_price = in.nextFloat();
        System.out.println("Please enter item cost:");
        item_cost = in.nextFloat();
        System.out.println("Please enter item quantity:");
        item_quantity = in.nextInt();
        Item iItem = new Item(id, item_name, item_price, item_cost, item_quantity);
        items.add(iItem);
        System.out.println("--------------- Added Successfully -----------");

    }

    public static void editItem() {
        if (items.size() == 0) {
            System.out.println("There is no item in the inventory ");
        } else {
            int number;
            System.out.println("Please select one of the items:");
            for (Item iItem : items) {
                System.out.println(iItem.getId() + "...." + iItem.getName());
            }
            System.out.println("Your ID is:");
            number = in.nextInt();
            boolean flag = true;
            for (Item iItem : items) {
                if (number == iItem.getId()) {
                    flag = false;
                    System.out.println("Item Details:");
                    System.out.println("ID: " + iItem.getId());
                    System.out.println("Name: " + iItem.getName());
                    System.out.println("Price: " + iItem.getPrice());
                    System.out.println("Cost: " + iItem.getCost());
                    System.out.println("Quantity: " + iItem.getQuantity());
                    String item_name;
                    double item_price,
                            item_cost;
                    int item_quantity;
                    System.out.println("Please enter item new name:");
                    item_name = in.next();
                    iItem.setName(item_name);
                    System.out.println("Please enter item new price:");
                    item_price = in.nextFloat();
                    iItem.setPrice(item_price);
                    System.out.println("Please enter item new cost:");
                    item_cost = in.nextFloat();
                    iItem.setCost(item_cost);
                    System.out.println("Please enter item new quantity:");
                    item_quantity = in.nextInt();
                    iItem.setQuantity(item_quantity);
                    System.out.println(" Updated Successfully ");
                }
            }
            if (flag == true) {
                System.out.println("- Error -");
                editItem();
            }
        }
    }

    public static void searchItem() {
        boolean flag = true;
        if (items.size() == 0) {
            System.out.println("There is no item in the inventory ");
        } else {
            System.out.println("Please select search type:");
            System.out.println("1- Search by Id.");
            System.out.println("2- Search by Name.");
            System.out.println("3- Back.");
            int number;
            System.out.println("Your number is:");
            number = in.nextInt();
            do {
                switch (number) {
                    case 1:
                        flag = true;
                        System.out.println("Please enter  your Id:");
                        number = in.nextInt();
                        for (Item aItem : items) {
                            if (number == aItem.getId()) {
                                flag = false;
                                System.out.println("Item Details:");
                                System.out.println("ID: " + aItem.getId());
                                System.out.println("Name: " + aItem.getName());
                                System.out.println("Price: " + aItem.getPrice());
                                System.out.println("Cost: " + aItem.getCost());
                                System.out.println("Quantity: " + aItem.getQuantity());
                                System.out.println("---------");
                                searchItem();
                            }
                        }
                        if (flag == true) {
                            System.out.println("------ Error ----------");
                            searchItem();
                        }
                        break;
                    case 2:
                        flag = true;
                        System.out.println("Please enter  your Name:");
                        String name = in.next();
                        for (Item aItem : items) {
                            if (name.equalsIgnoreCase(aItem.getName())) {
                                flag = false;
                                System.out.println("Item Details:");
                                System.out.println("ID: " + aItem.getId());
                                System.out.println("Name: " + aItem.getName());
                                System.out.println("Price: " + aItem.getPrice());
                                System.out.println("Cost: " + aItem.getCost());
                                System.out.println("Quantity: " + aItem.getQuantity());
                                System.out.println("-------------------------");
                                searchItem();
                            }
                        }
                        if (flag == true) {
                            System.out.println("----------- Error ------------");
                            searchItem();
                        }
                        break;
                    case 3:
                        menu();
                        break;
                    default:
                        System.out.println("--------- Error ---------");
                        break;
                }
            } while (true);
        }
    }

    public static void deleteItem() {
        if (items.size() == 0) {
            System.out.println("There is no item in the inventory ");
        } else {
            int number;
            System.out.println("Please select one of the items:");
            for (Item iItem : items) {
                System.out.println(iItem.getId() + "- " + iItem.getName());
            }
            System.out.println("Your ID is:");
            number = in.nextInt();
            boolean flag = true;
            int position = 0;
            for (Item iItem : items) {
                position++;
                if (number == iItem.getId()) {
                    flag = false;
                    System.out.println("Item Details:");
                    System.out.println("ID: " + iItem.getId());
                    System.out.println("Name: " + iItem.getName());
                    System.out.println("Price: " + iItem.getPrice());
                    System.out.println("Cost: " + iItem.getCost());
                    System.out.println("Quantity: " + iItem.getQuantity());
                    System.out.println("Are you sure do you want to delete?");
                    System.out.println("1- Yes");
                    System.out.println("2- No");
                    do {
                        System.out.println("Your choice is:");
                        number = in.nextInt();
                        switch (number) {
                            case 1:
                                iItem = null;
                            // items.remove((position - 1));
                                menu();
                                break;
                            case 2:
                                menu();
                                break;
                            default:
                                System.out.println("----------------- Error ------------------");
                                break;
                        }
                    } while (true);
                }

            }
            if (flag == true) {
                System.out.println("----------------- Error ------------------");
                deleteItem();
            }
        }
    }

    public static void addCustomer() {
        String name, address, email;
        int phone;
        System.out.println("Please enter customer name:");
        name = in.next();
        System.out.println("Please enter customer address:");
        address = in.next();
        System.out.println("Please enter customer email:");
        email = in.next();
        System.out.println("Please enter customer phone:");
        phone = in.nextInt();

        Customer aCustomer = new Customer(name, address, email, phone);
        customer.add(aCustomer);  
         System.out.println("--------------- Added Successfully -----------");

    }

    public static void viewAllItem() {
        
        if (items.size() == 0) {
            System.out.println("There is no item in the inventory ");
        } else {
            System.out.println("Items:");
            for (Item iItem : items) {
                System.out.println("ID: " + iItem.getId()
                        + ", Name: " + iItem.getName()
                        + ", Price: " + iItem.getPrice()
                        + ", Cost: " + iItem.getCost()
                        + ", Quantity: " + iItem.getQuantity());
            }
        }
    }

    public static void sellAnItem() {
        if (items.size() == 0) {
            System.out.println("There is no item in the inventory");
        } else if (customer.size() == 0) {
            System.out.println("There is no customers!");
        } else {
            System.out.println("Items:");
            for (Item aItem : items) {
                System.out.println("ID: " + aItem.getId()
                        + ", Name: " + aItem.getName()
                        + ", Price: " + aItem.getPrice()
                        + ", Cost: " + aItem.getCost()
                        + ", Quantity: " + aItem.getQuantity());
            }
            if(customer.size() == 0){
                System.out.println("Erorr");
               menu();
            }
            
            int number;
            System.out.println("Your ID is:");
            number = in.nextInt();
            boolean flag = true;
            for (Item aItem : items) {
                if (number == aItem.getId()) {
                    flag = false;
                    int id = invoice_id;
                    invoice_id++;
                    int quantity;
                    Customer c;
                    Item i = aItem;
                    double total_cost, total_price, reminder;
                    System.out.println("Enter your quantity:");
                    quantity = in.nextInt();
                    number = 1;
                    if ((aItem.getQuantity() - quantity) <= 15) {
                        System.out.println("The quantity become less than 15, do you want to continue?");
                        System.out.println("1- Yes");
                        System.out.println("2- No");
                        do {
                            System.out.println("Your choice is:");
                            number = in.nextInt();
                        } while (number != 1 && number != 2);
                    }

                    switch (number) {
                        case 1:
                            for (Customer aCustomer : customer) {
                                System.out.println("Name: " + aCustomer.getName());
                            }
                            flag = true;
                            do {
                                System.out.println("-------------- Customers: --------------");
                                System.out.println("Enter customer name:");
                                String c_name;
                                c_name = in.next();
                                for (Customer aCustomer : customer) {
                                    if (c_name.equalsIgnoreCase(aCustomer.getName())) {
                                        flag = false;
                                        c = aCustomer;
                                        System.out.println("Enter how much money the customer pay:");
                                        double money = in.nextDouble();
                                        total_price = quantity * aItem.getPrice();
                                        total_cost = quantity * aItem.getCost();
                                        reminder = total_price - money;
                                        aItem.setQuantity(aItem.getQuantity() - quantity);
                                        InvoiceDetails aInvoiceDetails = new InvoiceDetails(i, quantity, id, c, total_cost, total_price, reminder);
                                        invoice.add(aInvoiceDetails);
                                    }
                                }
                            } while (flag);
                            menu();
                            break;
                        case 2:
                            menu();
                            break;
                        default:
                            System.out.println("----------------- Error ------------------");
                            break;
                    }

                }
            }
            if (flag == true) {
                System.out.println("----------------- Error ------------------");
                sellAnItem();
            }
        }
    }

    public static void viewInvoices() {
        for (InvoiceDetails aInvoice : invoice) {
            System.out.println("id: " + aInvoice.getId()
                    + ", Customer: " + aInvoice.getaCustomer().getName()
                    + ", Item: " + aInvoice.getaItem().getName()
                    + ", Quantity: " + aInvoice.getQuantity()
                    + ", Total cost: " + aInvoice.getTotal_cost()
                    + ", Total price: " + aInvoice.getTotal_price()
                    + (aInvoice.getRemainder() > 0 ? "Reminder: " + aInvoice.getRemainder() : ""));
        }
    }

    public static void viewProfits() {
        double profits = 0.0;
        System.out.println("Invoices:");
        for (InvoiceDetails aInvoice : invoice) {
            profits += (aInvoice.getTotal_cost() - aInvoice.getTotal_price());
        }
        System.out.println("The Total of Daily Profits is: " + profits);
    }

    public static void viewInvoiceById() {
        int number;
        boolean flag = true;
        if (invoice.size() == 0) {
            System.out.println("There is no invoice in the market !");
        } else {
            for (InvoiceDetails aInvoice : invoice) {
                System.out.println("id: " + aInvoice.getId());
            }
            flag = true;
            do {
                System.out.println("Please enter your Id:");
                number = in.nextInt();
                for (InvoiceDetails aInvoice : invoice) {
                    if (number == aInvoice.getId()) {
                        flag = false;
                        System.out.println("id: " + aInvoice.getId()
                                + ", Customer: " + aInvoice.getaCustomer().getName()
                                + ", Item: " + aInvoice.getaItem().getName()
                                + ", Quantity: " + aInvoice.getQuantity()
                                + ", Total cost: " + aInvoice.getTotal_cost()
                                + ", Total price: " + aInvoice.getTotal_price()
                                + ", Reminder: " + aInvoice.getRemainder());
                        System.out.println("--------------------------------------------------------");
                    }
                }
            } while (flag);
        }
    }

    private static void viewInvoicesReminder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

    
     
    

