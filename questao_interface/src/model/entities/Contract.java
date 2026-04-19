package model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    protected Integer number;
    protected LocalDate date;
    protected BigDecimal totalValue;

    private List<Installment> installments = new ArrayList<>();

    public Contract(Integer number, LocalDate date, BigDecimal totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public void addInstallment(Installment installment){
        installments.add(installment);
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public void installmentsList(){
        for (Installment i : installments){
            System.out.println(i);
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                "number=" + number +
                ", date=" + date +
                ", totalValue=" + totalValue +
                ", installments=" + installments +
                '}';
    }
}
