package pl.sda.javawwa.sklepik.domain;

import java.math.BigDecimal;

public class Money {

    private BigDecimal value;

    //2 konstruktury, w obu ustawiam zaokrąglenie wartości do 2 miejsc po przecinku
    //z zaokrąglaniem do parzystej

    public Money(BigDecimal value) {
        this.value = value
                .setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public Money(double value) {
        this.value = BigDecimal.valueOf(value)
                .setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money multiplyBy(float multiplier) {
        BigDecimal multiplyEfect = value.multiply(BigDecimal.valueOf(multiplier))
                .setScale(2,BigDecimal.ROUND_HALF_EVEN);
        return new Money(multiplyEfect);
    }

    public Money add(Money money) {
        BigDecimal sumEfect = this.value.add(money.getValue())
                .setScale(2,BigDecimal.ROUND_HALF_EVEN);
        return new Money(sumEfect);
    }

    public Money subtract(Money money) {
        BigDecimal subtractEfect = this.value.subtract(money.getValue())
                .setScale(2,BigDecimal.ROUND_HALF_EVEN);
        return new Money(subtractEfect);
    }

    private boolean areValuesSame(Money money) {
        if (this.value.compareTo(money.value) == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money moneyTmp = (Money) o;

        return areValuesSame(moneyTmp);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

}