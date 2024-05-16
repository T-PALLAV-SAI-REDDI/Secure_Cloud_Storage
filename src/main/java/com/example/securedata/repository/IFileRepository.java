package com.example.securedata.repository;

import com.example.securedata.modal.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


@Repository
public interface IFileRepository extends JpaRepository<File,Long> {

}
