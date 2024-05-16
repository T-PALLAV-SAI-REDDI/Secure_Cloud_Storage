package com.example.securedata.service;

import com.example.securedata.modal.Dataowner;

import java.util.List;
import java.util.Optional;


public interface IDataownerService {

    Dataowner addDataowner(Dataowner dataOwner);

    List<Dataowner> getDataowner();

    Optional<Dataowner> getDataownerById(Long id);

    Dataowner updateDataowner(Dataowner dataowner);

    void deleteDataowner(Long id);

    Dataowner findByEmailAndPassword(String email,String password);
}
