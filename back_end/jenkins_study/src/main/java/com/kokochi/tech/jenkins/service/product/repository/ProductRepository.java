package com.kokochi.tech.jenkins.service.product.repository;

import com.kokochi.tech.jenkins.domain.product.Product;
import com.kokochi.tech.jenkins.domain.product.enumType.ProductSeasonType;
import com.kokochi.tech.jenkins.domain.product.enumType.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByProductType(ProductType productType, Pageable pageable);

    Page<Product> findByProductSeasonType(ProductSeasonType productSeasonType, Pageable pageable);

    Page<Product> findByProductTitleContains(String productTitle, Pageable pageable);
}
