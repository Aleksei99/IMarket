package by.smuraha.market;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FullOrderDto {
    private List<BasketDto> baskets;
    private BigDecimal totalSum;
}
