package com.example.securedata.modal;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class File {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String fileName;

        private String description;

        @Lob @Column(length=1000,columnDefinition = "MEDIUMBLOB")
        private byte[] file;

        private String filepath;

        public File(String fileName, String description, byte[] file) {
                this.fileName = fileName;
                this.description = description;
                this.file = file;
        }


        public File(String path) {

        }
}

