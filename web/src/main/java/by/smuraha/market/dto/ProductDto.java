package by.smuraha.market.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String brand;
    private String name;
    private BigDecimal price;
    private String description;
    private Long subCategoryID;
}
