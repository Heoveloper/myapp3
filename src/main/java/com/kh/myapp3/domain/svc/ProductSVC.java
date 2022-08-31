package com.kh.myapp3.domain.svc;

import com.kh.myapp3.domain.Product;

public interface ProductSVC {

    //상품등록

    /**
     * 상품등록
     * @param product 상품정보
     * @return  등록된 상품정보
     */
    Product save(Product product);
}
