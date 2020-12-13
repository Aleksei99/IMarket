package by.smuraha.market.dto;

import lombok.Data;

@Data
public class SubCategoryDto {
    private Long id;
    private String name;
    private Long category_id;

    public SubCategoryDto(Long id, String name, Long category_id) {
        this.id=id;
        this.name=name;
        this.category_id=category_id;
    }
}
