package com.kh.myapp3.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemForm {
    private Long productId;
    private String pname;
    private Integer quantity;
    private Integer price;
}
