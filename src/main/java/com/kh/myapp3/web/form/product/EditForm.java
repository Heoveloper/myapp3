package com.kh.myapp3.web.form.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditForm {
    private Long productId;     // 상품아이디 PRODUCT_ID NUMBER(10,0) No 1
    private String pname;       // 상품명 PNAME	VARCHAR2(30 BYTE) Yes 2
    private Integer quantity;   // 수량 QUANTITY NUMBER(10,0) Yes 3
    private Integer price;      // 가격 PRICE	NUMBER(10,0) Yes 4
}
