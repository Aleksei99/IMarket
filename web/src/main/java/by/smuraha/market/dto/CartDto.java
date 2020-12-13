package by.smuraha.market.dto;

import by.smuraha.market.entity.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDto {
    List<Product> products = new ArrayList<>();
}
