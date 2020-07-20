package com.ecom.order.tools;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CurrencyCLP {

    public BigDecimal applyDiscount(BigDecimal total, BigDecimal discountPercentage){
        return this.roundClp(this.substractRoundingDecimals(total, discountPercentage));
    }

    public BigDecimal calculateAmountByPercentage(BigDecimal total, BigDecimal taxPercentage){
        if(taxPercentage.compareTo(new BigDecimal(0)) == 1){
            return this.calculatePercentage(total, taxPercentage).setScale(0, RoundingMode.CEILING);
        }
        else {
            return new BigDecimal(0);
        }
    }

    public BigDecimal roundClp(BigDecimal total){
        total = total.setScale(0, RoundingMode.CEILING);
        BigDecimal remainder = total.remainder(new BigDecimal(10));

        if( (remainder.compareTo(new BigDecimal(1)) == 0 || remainder.compareTo(new BigDecimal(1)) == 1) &&
                (remainder.compareTo(new BigDecimal(5)) == 0 || remainder.compareTo(new BigDecimal(5)) == -1) ){
            return total.subtract(remainder);
        }
        if( (remainder.compareTo(new BigDecimal(6)) == 0 || remainder.compareTo(new BigDecimal(6)) == 1) &&
                (remainder.compareTo(new BigDecimal(9)) == 0 || remainder.compareTo(new BigDecimal(9)) == -1) ){
            return total.add(new BigDecimal(10).subtract(remainder));
        }
        return total;
    }



    private BigDecimal addRoundingDecimals(BigDecimal total, BigDecimal percentage){
        if(percentage.compareTo(new BigDecimal(0)) == 1){
            return total.add(this.calculatePercentage(total, percentage)).setScale(0, RoundingMode.CEILING);
        }
        else {
            return total;
        }
    }

    private BigDecimal substractRoundingDecimals(BigDecimal total, BigDecimal percentage){
        if(percentage.compareTo(new BigDecimal(0)) == 1){
            return total.subtract(this.calculatePercentage(total, percentage)).setScale(0, RoundingMode.CEILING);
        }
        else {
            return total;
        }
    }

    private BigDecimal calculatePercentage(BigDecimal value, BigDecimal percentage){
        return (percentage.multiply(value)).divide(new BigDecimal(100));
    }
}
