package entities;

import entities.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private static Integer contador = 0;
    private Integer id;
    private LocalDateTime moment;

    private OrderStatus status;
    private Client client;
    private ArrayList<OrderItem> itens = new ArrayList<>();

    public Order( Client client) {
        contador++;
        this.id = contador;
        this.moment = LocalDateTime.now();
        this.status = OrderStatus.PROCESSING;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public LocalDateTime getMoment() {
        return moment;
    }

    public void addItem(OrderItem item){
        itens.add(item);
    }
    public void removeItem(OrderItem item){
        itens.remove(item);
    }

    public BigDecimal total(){
        BigDecimal total = BigDecimal.ZERO;
        for(OrderItem item : itens){
            total = total.add(item.subTotal());
        }
        return total;
    }

    @Override
    public String toString() {
        String texto = "";
        for (OrderItem item : itens){
            texto += item + "\n";
        }
        return texto;
    }
}
