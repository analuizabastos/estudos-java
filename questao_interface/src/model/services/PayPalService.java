package model.services;

import java.math.BigDecimal;

public class PayPalService implements OnlinePaymentService {

    @Override
    public BigDecimal paymentFee(BigDecimal amount) {
        BigDecimal tax = new BigDecimal("0.02");
        return amount.multiply(tax);
    }

    @Override
    public BigDecimal interest(BigDecimal amount, Integer months) {
        BigDecimal monthTax = new BigDecimal("0.01");
        BigDecimal juroTotal = monthTax.multiply(new BigDecimal(months));
        return amount.multiply(juroTotal);
    }
}
