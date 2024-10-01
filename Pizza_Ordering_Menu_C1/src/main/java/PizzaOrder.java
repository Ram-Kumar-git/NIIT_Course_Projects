import java.util.Scanner;

public class PizzaOrder
{

    public float getPriceOfPizzaBasedOnSize(int size)
    {
        if (size == 1)
        {
            return 9.99f;
        }
        else if (size == 2)
        {
            return 11.99f;
        }
        else if (size == 3)
        {
            return 13.99f;
        }
        else
        {
            return 0.00f;
        }
    }

    public float getPriceOfGarlicBread()
    {
        return 5.99f;
    }

    public float getPriceOfBeverage()
    {
        return 1.99f;
    }

    public float calculatePriceOfPizza(int noOfPizza, float priceOfPizza)
    {
        return noOfPizza * priceOfPizza;
    }

    public float calculatePriceOfGarlicBread(int noOfGarlicBread, float priceOfGarlicBread)
    {
        return noOfGarlicBread * priceOfGarlicBread;
    }

    public float calculatePriceOfBeverage(int noOfBeverages, float priceOfBeverages)
    {
        return noOfBeverages * priceOfBeverages;
    }

    public float calculateTotalBill(float totalPizzaPrice, float totalGarlicBreadPrice, float totalBeveragesPrice)
    {
        return totalPizzaPrice + totalGarlicBreadPrice + totalBeveragesPrice;
    }

    public float calculateDiscountAndReturnBillAmount(float totalBillAmount)
    {
        if (totalBillAmount > 50)
        {
            return totalBillAmount - (totalBillAmount * 0.1f);
        }
        else
        {
            return totalBillAmount;
        }
    }

    void displayCustomerDetails(String name, String email, long phoneNo, String address)
    {
        System.out.println("Customer Details");
        System.out.println("-----------------");
        System.out.println("Name of the Customer is : " + name);
        System.out.println("Email of the Customer is : " + email);
        System.out.println("Contact No of the Customer is : " + phoneNo);
        System.out.println("Address of the Customer is : " + address);
        System.out.println("---------------------------------------------");
    }

    public void displayMenu() {
        System.out.println("Select the item to order");
        System.out.println("Sl No      Item Category");
        System.out.println("-----------------");
        System.out.println("1) Pizza");
        System.out.println("   Price of One Regular Pizza  :$9.99");
        System.out.println("   Price of One Medium Pizza   :$11.99");
        System.out.println("   Price of One Large Pizza    :$13.99");
        System.out.println("2) Garlic Bread");
        System.out.println("   Price of One Garlic Bread   :$5.99");
        System.out.println("3) Beverages");
        System.out.println("   Price of One Beverage       :$1.99");
        System.out.println("Enter 1 for Pizza, 2 for Garlic Bread, 3 for Beverages");
    }

    public void displayOrderDetails(int noOfPizza, int noOfGarlicBread, int noOfBeverages, float totalBillAmount, float totalPrizeAfterDiscount)
    {
        System.out.println("Order Details");
        System.out.println("--------------");
        System.out.println("The number of pizzas ordered       : " + noOfPizza);
        System.out.println("The number of garlic bread ordered : " + noOfGarlicBread);
        System.out.println("The number of beverages ordered    : " + noOfBeverages);
        System.out.println("-------------------------------------------------");
        System.out.println("The Total Bill Amount is              : $" + totalBillAmount);
        if (totalBillAmount != totalPrizeAfterDiscount)
        {
            System.out.println("The Discounted Bill Amount is         : $" + totalPrizeAfterDiscount);
        }
        else
        {
            System.out.println("No Discount on Bill");
        }
    }

    public static void main(String[] args)
    {
        PizzaOrder pizzaOrdering = new PizzaOrder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name :");
        String name = sc.nextLine();
        System.out.println("Enter email :");
        String email = sc.nextLine();
        System.out.println("Enter Address :");
        String address = sc.nextLine();
        System.out.println("Enter Phone :");
        long phoneNo = sc.nextLong();

        int choice, more, noofpi = 0, noofgb = 0, noofbe = 0;
        float totalPizzaBill = 0, totalGarlicBreadBill = 0, totalBeveragesbill = 0;

        do {
            pizzaOrdering.displayMenu();
            choice = sc.nextInt();
            switch (choice)
            {
                case 1: // Pizza
                    System.out.println("Enter the size of Pizza you want to order, Enter 1 for Regular, 2 for Medium, 3 for Large");
                    int pisize = sc.nextInt();
                    float pp = pizzaOrdering.getPriceOfPizzaBasedOnSize(pisize); // takes price
                    System.out.println("Please enter the number of pizza you want to order :");
                    int pizzaqu = sc.nextInt(); // takes quantity;
                    noofpi = noofpi + pizzaqu; // takes additional quantity;
                    totalPizzaBill = totalPizzaBill + pizzaOrdering.calculatePriceOfPizza(pizzaqu, pp); // calculates final pizza price pp-pricewithsize,pizzaqu-quantity
                    break;

                case 2: // Garlic Bread
                    System.out.println("Please enter the number of garlic bread you want to order :");
                    int garlicqu = sc.nextInt(); // takes quantity
                    noofgb = noofgb + garlicqu; // takes additional quantity
                    totalGarlicBreadBill = totalGarlicBreadBill + pizzaOrdering.calculatePriceOfGarlicBread(garlicqu, pizzaOrdering.getPriceOfGarlicBread()); // calculate final garlic bread price
                    break;

                case 3: // Beverages
                    System.out.println("Please enter the number of beverages you want to order :");
                    int beveragequ = sc.nextInt();// takes quantity
                    noofbe = noofbe + beveragequ;//addes quantity
                    totalBeveragesbill = totalBeveragesbill + pizzaOrdering.calculatePriceOfBeverage(beveragequ, pizzaOrdering.getPriceOfBeverage()); // calculate final beverage price
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
                    break;
            }
            System.out.println("Do you wish to add more items to your order? Enter 1 to continue or 0 to exit");
            more = sc.nextInt();
        } while (more == 1);

        pizzaOrdering.displayCustomerDetails(name, email, phoneNo, address);
        float totalBillAmount = pizzaOrdering.calculateTotalBill(totalPizzaBill, totalGarlicBreadBill, totalBeveragesbill);//these variables has the total price respectively

        float totalPrizeAfterDiscount = pizzaOrdering.calculateDiscountAndReturnBillAmount(totalBillAmount);
        pizzaOrdering.displayOrderDetails(noofpi, noofgb, noofbe, totalBillAmount, totalPrizeAfterDiscount);//these variables display quantity of each and final price and discount if needed

    }
}
