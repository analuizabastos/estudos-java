package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {

        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract cr, Integer months){

        for (Integer i = 1; i <= months; i++){
            LocalDate dueDate = cr.getDate().plusMonths(i);
            BigDecimal priceMonth = cr.getTotalValue().divide(new BigDecimal(months), 2, RoundingMode.HALF_UP);
            BigDecimal interest = onlinePaymentService.interest(priceMonth, i);
            BigDecimal priceWithInterest = priceMonth.add(interest);
            BigDecimal fee = onlinePaymentService.paymentFee(priceWithInterest);
            BigDecimal amount = priceWithInterest.add(fee);
            cr.addInstallment(new Installment(dueDate, amount));
        }
    }

}
