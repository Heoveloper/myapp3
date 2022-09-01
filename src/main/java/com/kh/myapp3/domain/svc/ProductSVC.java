package com.kh.myapp3.domain.svc;

import com.kh.myapp3.domain.Product;

import java.util.List;

public interface ProductSVC {

    /**
     * 상품등록
     * @param product 상품정보
     * @return  등록된 상품
     */
    Product save(Product product);

    /**
     * 상품조회
     * @param productId 상품아이디
     * @return 상품
     */
    Product findById(Long productId);

    /**
     * 상품수정
     * @param product 수정할 상품정보
     */
    void update(Long productId, Product product);

    /**
     * 상품삭제
     * @param productId 상품아이디
     * @return
     */
    void delete(Long productId);

    /**
     * 목록
     * @return 상품전체
     */
    List<Product> findAll();

    /**
     * 전체삭제
     */
    void deleteAll();
}
