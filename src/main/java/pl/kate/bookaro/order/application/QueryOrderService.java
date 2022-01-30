package pl.kate.bookaro.order.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kate.bookaro.order.application.port.QueryOrderUseCase;
import pl.kate.bookaro.order.application.price.OrderPrice;
import pl.kate.bookaro.order.application.price.PriceService;
import pl.kate.bookaro.order.db.OrderJpaRepository;
import pl.kate.bookaro.order.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class QueryOrderService implements QueryOrderUseCase {
    private final OrderJpaRepository repository;
    private final PriceService priceService;

    @Override
    @Transactional
    public List<RichOrder> findAll() {
        return repository.findAll()
                         .stream()
                         .map(this::toRichOrder)
                         .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<RichOrder> findById(Long id) {
        return repository.findById(id).map(this::toRichOrder);
    }

    private RichOrder toRichOrder(Order order) {
        OrderPrice orderPrice = priceService.calculatePrice(order);
        return new RichOrder(
            order.getId(),
            order.getStatus(),
            order.getItems(),
            order.getRecipient(),
            order.getCreatedAt(),
            orderPrice,
            orderPrice.finalPrice()
        );
    }
}
