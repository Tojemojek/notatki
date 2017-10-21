package pl.sda.javawwa.sklepik.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private BigDecimal value;

    //2 konstruktury, w obu ustawiam zaokrąglenie wartości do 2 miejsc po przecinku
    //z zaokrąglaniem do parzystej

    private Money(BigDecimal value) {
        this.value = value
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    public Money multiplyBy(double multiplier) {
        BigDecimal multiplyEfect = value.multiply(BigDecimal.valueOf(multiplier))
                .setScale(2,RoundingMode.HALF_EVEN);
        return new Money(multiplyEfect);
    }

    public Money add(Money money) {
        BigDecimal sumEfect = this.value.add(money.getValue())
                .setScale(2,RoundingMode.HALF_EVEN);
        return new Money(sumEfect);
    }

    public Money subtract(Money money) {
        BigDecimal subtractEfect = this.value.subtract(money.getValue())
                .setScale(2,RoundingMode.HALF_EVEN);
        return new Money(subtractEfect);
    }

    public int compareTo(Money money) {
        return this.value.compareTo(money.getValue());
    }

    private boolean areSameValues(Money money) {
        if (this.value.compareTo(money.value) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Money(String value) {
        this(new BigDecimal(value));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money moneyTmp = (Money) o;

        return areSameValues(moneyTmp);
    }



    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

}