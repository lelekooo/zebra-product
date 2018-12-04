package br.com.zebra.product.rest;

import br.com.zebra.product.model.Product;
import br.com.zebra.product.model.util.ProductSwaggerStrings;
import br.com.zebra.product.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductRest {

    @Autowired
    private ProductService productService;


    @ApiOperation(
            value = ProductSwaggerStrings.ApiOperationValue.GET_PRODUCT_VALUE,
            notes = ProductSwaggerStrings.ApiOperationValue.GET_PRODUCT_NOTES
    )
    @RequestMapping(path = "{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Product> getProduct(
            @RequestHeader(value="TCC-IP") String tccIp,
            @PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @ApiOperation(
            value = ProductSwaggerStrings.ApiOperationValue.GET_PRODUCTS_VALUE,
            notes = ProductSwaggerStrings.ApiOperationValue.GET_PRODUCTS_NOTES
    )
    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Product> getProducts(@RequestHeader(value="TCC-IP") String tccIp) {
        return productService.getProducts();
    }

}
