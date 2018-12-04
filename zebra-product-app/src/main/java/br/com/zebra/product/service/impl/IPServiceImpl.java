package br.com.zebra.product.service.impl;

import br.com.zebra.product.model.util.IP;
import br.com.zebra.product.repository.mongo.IPRepository;
import br.com.zebra.product.service.IPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPServiceImpl implements IPService {

    @Autowired
    IPRepository ipRepository;

    @Override
    public List<IP> getAll(){
        return ipRepository.findAll();
    }

    @Override
    public IP getOne(String ip){
        return ipRepository.findByIp(ip);
    }

    @Override
    public IP save(IP ip){
        return ipRepository.save(ip);
    }

    @Override
    public void delete(IP ip){
        ipRepository.delete(ip);
    }
}
