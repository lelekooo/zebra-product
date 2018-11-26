package br.com.zebra.product.service;

import br.com.zebra.product.model.Product;

import java.util.List;

public interface ProductService {


    List<Product> getProducts();

    Product getProduct(Long id);
}
