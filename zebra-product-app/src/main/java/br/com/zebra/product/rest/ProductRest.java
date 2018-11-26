package br.com.zebra.product.rest;

import br.com.zebra.product.model.Product;
import br.com.zebra.product.model.util.ProductSwaggerStrings;
import br.com.zebra.product.model.util.SwaggerStrings;
import br.com.zebra.product.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductRest {

    @Autowired
    private ProductService productService;


    @ApiOperation(
            value = ProductSwaggerStrings.ApiOperationValue.GET_PRODUCT_VALUE,
            notes = ProductSwaggerStrings.ApiOperationValue.GET_PRODUCT_NOTES
    )
    @RequestMapping(path = "/product",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getPayments(
            @ApiParam(value = SwaggerStrings.ApiParamValue.ID, required = true)
            @RequestParam(required = false) Long id) {
        return productService.getProduct(id);
    }

    @ApiOperation(
            value = ProductSwaggerStrings.ApiOperationValue.GET_PRODUCTS_VALUE,
            notes = ProductSwaggerStrings.ApiOperationValue.GET_PRODUCTS_NOTES
    )
    @RequestMapping(path = "/products", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
