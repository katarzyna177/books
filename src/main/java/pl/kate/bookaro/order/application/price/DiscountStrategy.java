package pl.kate.bookaro.order.application.price;

import pl.kate.bookaro.order.domain.Order;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal calculate(Order order);
}
