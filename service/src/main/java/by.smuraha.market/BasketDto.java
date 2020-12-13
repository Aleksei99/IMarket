package by.smuraha.market;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasketDto {
    private Long productID;
    private int count;
}
