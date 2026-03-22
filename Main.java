import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpledate = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = simpledate.parse(sc.next());
        Client client1 = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.println("Status: " + OrderStatus.PROCESSING);
        Order pedido = new Order(client1);
        System.out.print("How many items to this order? ");
        Integer itensQuantity = sc.nextInt();
        sc.nextLine();

        for(Integer i = 0; i < itensQuantity; i++){
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            String priceText = sc.nextLine();
            BigDecimal productPrice = new BigDecimal(priceText);
            Product product1 = new Product(productName, productPrice);
            System.out.print("Quantity: ");
            Integer productQuantity = sc.nextInt();
            sc.nextLine();
            OrderItem item1 = new OrderItem(productQuantity, product1);
            pedido.addItem(item1);
        }

        System.out.println("\nOrder Summary: ");
        System.out.println("Order Moment: " + pedido.getMoment().format(fmt));
        System.out.println("Order Status: " + pedido.getStatus());
        System.out.println("Client: " + client1);
        System.out.println("Order Itens: " + pedido);
        System.out.println("Total Price: $" + pedido.total());

        sc.close();
    }

}