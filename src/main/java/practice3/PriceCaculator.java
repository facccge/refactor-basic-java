package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {

    private BigDecimal subTotal;
    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public PriceCaculator(Order order) {
        subTotal = new BigDecimal(0);
        tax = order.getTax();
        orderLineItemList = order.getOrderLineItemList();
        discounts = order.getDiscounts();
    }

    public void calculateSubTotal() {
        // Total up line items
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
    }

    public void substractDiscounts() {
        // Subtract discounts
        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }
    }

    public BigDecimal calculateTax() {
        // calculate tax
        return subTotal = subTotal.add(subTotal.multiply(tax));
    }

    public BigDecimal calculateGrandTotal() {
        // calculate GrandTotal
        calculateSubTotal();
        substractDiscounts();
        calculateTax();

        return subTotal;
    }
}
