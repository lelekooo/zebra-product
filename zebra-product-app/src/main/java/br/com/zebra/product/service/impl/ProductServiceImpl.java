package br.com.zebra.product.service.impl;

import br.com.zebra.product.model.Product;
import br.com.zebra.product.repository.mongo.ProductRepository;
import br.com.zebra.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public Map<String, Product> getProducts(){
        List<Product> responseList = productRepository.findAll();
        Map<String, Product> resposeMap = new HashMap<String, Product>();
        responseList.forEach(product ->
                resposeMap.put(product.getIdProduct().toString(), product));
        return resposeMap;
    }

    @Override
    public Map<String, Product> getProduct(Long id){
        Product product = productRepository.findByIdProduct(id);
        Map<String, Product> resposeMap = new HashMap<String, Product>();
        resposeMap.put(product.getIdProduct().toString(), product);
        return resposeMap;

    }

}
