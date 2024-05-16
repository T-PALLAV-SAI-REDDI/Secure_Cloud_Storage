package com.example.securedata.repository;

import com.example.securedata.modal.Datauser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataUserRepository extends JpaRepository<Datauser,Long> {
    Datauser findByEmailAndPassword(String email, String password);
}
