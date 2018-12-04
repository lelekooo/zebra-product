package br.com.zebra.product.repository.mongo;

import br.com.zebra.product.model.util.IP;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPRepository extends MongoRepository<IP, Long> {

    public IP findByIp(String ip);

}
