package com.example.securedata.service.impl;

import com.example.securedata.modal.Dataowner;
import com.example.securedata.repository.IDataOwnerRepository;
import com.example.securedata.service.IDataownerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DataownerService implements IDataownerService {

    @Autowired
    private IDataOwnerRepository dataOwnerRepository;


    @Override
    public Dataowner addDataowner(Dataowner dataOwner) {
        return dataOwnerRepository.save(dataOwner);
    }

    @Override
    public List<Dataowner> getDataowner() {
        return dataOwnerRepository.findAll();
    }

    @Override
    public Optional<Dataowner> getDataownerById(Long id) {
        return dataOwnerRepository.findById(id);
    }

    @Override
    public Dataowner updateDataowner(Dataowner dataowner) {
        return dataOwnerRepository.save(dataowner);
    }

    @Override
    public void deleteDataowner(Long id) {
      dataOwnerRepository.deleteById(id);
    }

    @Override
    public Dataowner findByEmailAndPassword(String email, String password) {
        return dataOwnerRepository.findByEmailAndPassword(email,password);
    }
}
