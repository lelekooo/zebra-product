package br.com.zebra.product.model.util;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "allowed-ip")
public class IP {

    @Id
    String id;
    String ip;
}
