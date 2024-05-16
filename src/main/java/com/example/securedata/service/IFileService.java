package com.example.securedata.service;

import com.example.securedata.modal.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IFileService {

    File addFile(MultipartFile file) throws Exception;

    List<File> getFiles() ;

    Optional<String> getFile(Long id) throws Exception;

    File updaetFile(File file);

    void deleteFile(Long id);

}
