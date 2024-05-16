package com.example.securedata.repository;


import com.example.securedata.modal.Dataowner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataOwnerRepository extends JpaRepository<Dataowner,Long> {
    Dataowner findByEmailAndPassword(String email, String password);
}
