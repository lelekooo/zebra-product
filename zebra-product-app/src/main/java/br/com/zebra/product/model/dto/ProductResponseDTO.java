package br.com.zebra.product.model.dto;

import br.com.zebra.product.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ProductResponseDTO {

    Map<String, Product> response;

}
