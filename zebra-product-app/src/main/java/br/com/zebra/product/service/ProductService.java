package br.com.zebra.product.service;

import br.com.zebra.product.model.Product;

import java.util.Map;

public interface ProductService {


    Map<String, Product> getProducts();

    Map<String, Product> getProduct(Long id);
}
