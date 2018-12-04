package br.com.zebra.product.service;

import br.com.zebra.product.model.util.IP;

import java.util.List;

public interface IPService {

    List<IP> getAll();
    IP getOne(String ip);
    IP save(IP ip);
    void delete(IP ip);

}
