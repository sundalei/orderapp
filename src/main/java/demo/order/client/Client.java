package demo.order.client;

import demo.order.Order;
import demo.order.OrderProcess;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("demo/order/client/client-beans.xml");
        OrderProcess client = (OrderProcess) context.getBean("orderClient");

        Order order = new Order();
        order.setCustomerID("C001");
        order.setItemID("I001");
        order.setQty(100);
        order.setPrice(200.00);

        String orderID = client.processOrder(order);
        String message = (orderID == null) ? "Order not approved" : "Order approved; " +
                "order ID is " + orderID;
        System.out.println(message);
    }
}
