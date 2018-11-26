package br.com.zebra.product.service.impl;

import br.com.zebra.product.model.Product;
import br.com.zebra.product.repository.mongo.ProductRepository;
import br.com.zebra.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id){
        return productRepository.findByIdProduct(id);
    }

}
