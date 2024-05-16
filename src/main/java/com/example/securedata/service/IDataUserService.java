package com.example.securedata.service;

import com.example.securedata.modal.Datauser;

import java.util.List;
import java.util.Optional;

public interface IDataUserService {

    Datauser addDatauser(Datauser datauser);

    List<Datauser> getDatauser();

    Optional<Datauser> getDatauserById(Long id);

    Datauser updateDatauser(Datauser datauser);

    void deleteDatauser(Long id);

    Datauser FindByEmailAndPassword(String EMAIL,String password);
}
