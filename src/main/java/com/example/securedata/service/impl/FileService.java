package com.example.securedata.service.impl;

import com.example.securedata.modal.File;
import com.example.securedata.repository.IFileRepository;
import com.example.securedata.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.nio.file.*;
import java.security.*;
import java.util.List;
import java.util.Optional;

@Service
public class FileService implements IFileService {

    @Autowired
    private IFileRepository fileRepository;

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "rabbanerabbanera".getBytes();

    // Generate AES key
    private static Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, ALGORITHM);
    }

    // Encrypt content
    private static byte[] encrypt(byte[] content, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64Utils.encode(cipher.doFinal(content));
    }

    // Decrypt content
    private static byte[] decrypt(byte[] encryptedContent, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodeBytes = Base64Utils.decode(encryptedContent);
        return cipher.doFinal(decodeBytes);
    }

    // Save file in various formats
    private void saveFile(byte[] content, String filePath, String fileExtension) throws Exception {
        // Append the appropriate file extension to the file path
        String formattedFilePath = filePath + "." + fileExtension.toLowerCase();
        Files.write(Paths.get(formattedFilePath), content, StandardOpenOption.CREATE);
    }

    @Override
    public File addFile(MultipartFile file) throws Exception {
        Path path = Paths.get("", "static/files/");
        Key key = generateKey();

        byte[] content = file.getBytes();
        byte[] encryptedContent = encrypt(content, key);

        File fileEntity = File.builder()
                .fileName(file.getOriginalFilename())
                .description(file.getResource().getDescription())
                .file(encryptedContent)
                .filepath(String.valueOf(path))
                .build();

        return fileRepository.save(fileEntity);
    }

    @Override
    public List<File> getFiles() {
        return fileRepository.findAll();
    }

    @Override
    public Optional<String> getFile(Long id) throws Exception {
        Optional<File> fileOptional = fileRepository.findById(id);

        if (fileOptional.isPresent()) {
            File file = fileOptional.get();
            Key key = generateKey();
            byte[] decryptedContent = decrypt(file.getFile(), key);

            // Determine the original file format
            String originalFileName = file.getFileName();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

            // Save the decrypted content in the appropriate format
            String decryptedFilePath = "C:\\Users\\palla\\OneDrive\\Desktop\\DECRYPTED RESULTS/resultdata";
            saveFile(decryptedContent, decryptedFilePath, fileExtension);

            return Optional.ofNullable(decryptedFilePath);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public File updaetFile(File file) {
        return fileRepository.save(file);
    }

    @Override
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }
}
