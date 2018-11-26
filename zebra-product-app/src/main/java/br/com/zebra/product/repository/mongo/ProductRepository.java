package br.com.zebra.product.repository.mongo;

import br.com.zebra.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

    Product findByIdProduct(Long id);

}
