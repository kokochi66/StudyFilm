package com.kokochi.tech.jenkins.service.product;

import com.kokochi.tech.jenkins.domain.product.Product;
import com.kokochi.tech.jenkins.domain.product.ProductImg;
import com.kokochi.tech.jenkins.domain.product.ProductImgScore;
import com.kokochi.tech.jenkins.domain.user.User;
import com.kokochi.tech.jenkins.service.product.repository.ProductImgRepository;
import com.kokochi.tech.jenkins.service.product.repository.ProductImgScoreRepository;
import com.kokochi.tech.jenkins.service.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductImgRepository productImgRepository;
    private final ProductImgScoreRepository productImgScoreRepository;


    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product upsertProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public Page<ProductImg> getProductImgHotList(Pageable pageable) {
        return productImgRepository.findByHotListPaging(pageable);
    }

    public ProductImg upsertProductImg(ProductImg productImg) {
        return productImgRepository.save(productImg);
    }

    public void deleteProductImg(ProductImg productImg) {
        productImgRepository.delete(productImg);
    }

    public List<ProductImgScore> getProductImgScoreListByProductImg(Long productImgId) {
        return productImgScoreRepository.findAllByProductImgId(productImgId);
    }

    public List<ProductImgScore> getProductImgScoreByUser(Long userId) {
        return productImgScoreRepository.findAllByUserId(userId);
    }

    public ProductImgScore upsertProductImgScore(ProductImgScore productImgScore) {
        return productImgScoreRepository.save(productImgScore);
    }

    public void deleteProductImgScore(ProductImgScore productImgScore) {
        productImgScoreRepository.delete(productImgScore);
    }

}
