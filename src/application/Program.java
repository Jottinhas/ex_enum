package application;

import Model.entities.Client;
import Model.entities.Order;
import Model.entities.OrderItem;
import Model.entities.Product;
import Model.entities.entities_enum.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("ENTER CLIENT DATA:");

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        System.out.println();

        Client client = new Client(name, email, birthDate);

        System.out.println("ENTER ORDER DATA: ");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        System.out.println();

        Order order = new Order(new Date(), orderStatus, client);

        for (int i=1; i<=n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.next();
            String p_name = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();

            Product product = new Product(p_name, price);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER STATUS: ");
        System.out.println(order);



    }
}
