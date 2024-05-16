package com.example.securedata.service.impl;

import com.example.securedata.modal.Datauser;
import com.example.securedata.repository.IDataUserRepository;
import com.example.securedata.service.IDataUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DatauserService implements IDataUserService {

     @Autowired
    private IDataUserRepository dataUserRepository;

    @Override
    public Datauser addDatauser(Datauser datauser) {
        return dataUserRepository.save(datauser);
    }

    @Override
    public List<Datauser> getDatauser() {
        return dataUserRepository.findAll();
    }

    @Override
    public Optional<Datauser> getDatauserById(Long id) {
        return dataUserRepository.findById(id);
    }

    @Override
    public Datauser updateDatauser(Datauser datauser) {
        return dataUserRepository.save(datauser);
    }

    @Override
    public void deleteDatauser(Long id) {
        dataUserRepository.deleteById(id);
    }

    @Override
    public Datauser FindByEmailAndPassword(String email, String password) {
        return dataUserRepository.findByEmailAndPassword(email,password);
    }
}

























































