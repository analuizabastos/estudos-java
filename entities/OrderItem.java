package entities;

import java.math.BigDecimal;

public class OrderItem {
    private Integer quantity;
    private Product product;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public BigDecimal subTotal(){
        BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
        return subtotal;
    }

    @Override
    public String toString() {
        return product.getName() + ", $" + product.getPrice() + ", Quantity: " + getQuantity() + ", Subtotal $" + subTotal();
    }
}
