package com.example.securedata.controller;

import com.example.securedata.modal.File;
import com.example.securedata.service.IFileService;
import com.sun.source.tree.TryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class FileController {

    @Autowired
    private IFileService fileService;

    //ENDPOINT FOR ADDING THE FILE

    @PostMapping(value = "/file")
    private ResponseEntity<?> addFile(@RequestParam("file") MultipartFile file) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(fileService.addFile(file), HttpStatus.OK);
        } catch (Exception e) {
            res.put("error", "cannot add file");
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR GETTING ALL THE FILES
    @GetMapping("/file")
    private ResponseEntity<?> getFiles()
    {
        try
        {
            return new ResponseEntity<>(fileService.getFiles(),HttpStatus.OK);
        }
        catch(Exception e)
        {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR GETTING THE FILE
    @GetMapping("/file/{id}")
    private ResponseEntity<?> getFile(@PathVariable Long id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(fileService.getFile(id), HttpStatus.OK);
        } catch (Exception e) {
            res.put("error", "cannot get file");
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //ENDPOINT FOR UPDATING THE FILE
    @PutMapping("/file")
    private ResponseEntity<?> updateFile(@ModelAttribute File file) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(fileService.updaetFile(file), HttpStatus.OK);
        } catch (Exception e) {
            res.put("error", "file update failed");
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR DELETING THE FILE
    @DeleteMapping("/file/{id}")
    private ResponseEntity<?> deleteFile(@PathVariable Long id)
    {
        HashMap<String,String> res=new HashMap<>();
        try
        {
            fileService.deleteFile(id);
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in deleting file");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
