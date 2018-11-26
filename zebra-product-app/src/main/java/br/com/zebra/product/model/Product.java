package br.com.zebra.product.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Data
@Document(collection = "product")
public class Product {

    @Id
    BigInteger id;
    Long idProduct;
    String name;
    String description;
    List<Long> relatedProducts;
    Double price;
    List<String> urlImage;

}
