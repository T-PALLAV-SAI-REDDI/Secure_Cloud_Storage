package com.example.securedata.controller;


import com.example.securedata.modal.Dataowner;
import com.example.securedata.service.impl.DataownerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class DataownerController {

    @Autowired
    private DataownerService dataownerService;


    //ENDPOINT FOR ADDING THE DATAOWNER
    @PostMapping("/dataowner")
    private ResponseEntity<?> addDataowner(@RequestBody Dataowner dataowner)
    {
        HashMap<String,String> res= new HashMap<>();
        try
        {
            return new ResponseEntity<>(dataownerService.addDataowner(dataowner), HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in adding dataowner");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ENDPOINT FOR GETTING ALL THE DATAOWNER
    @GetMapping("/dataowner")
    private ResponseEntity<?> getDataowner()
    {
        HashMap<String,String> res= new HashMap<>();
        try
        {
            return new ResponseEntity<>(dataownerService.getDataowner(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in getting dataowners");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ENDPOINT FOR GETTING DATAOWNER BY ID
    @GetMapping("/dataowner/{id}")
    private ResponseEntity<?> dataOwnerById(@PathVariable Long id)
    {
        HashMap<String,String> res= new HashMap<>();
        try
        {
            return new ResponseEntity<>(dataownerService.getDataownerById(id),HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in getting the dataowner");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ENDPOOINT FOR UPDATING THE DATAOWNER BY ID
    @PutMapping("/dataowner")
    private ResponseEntity<?> updateDataowner(@RequestBody Dataowner dataowner)
    {
        HashMap<String,String> res= new HashMap<>();
        try
        {
            return new ResponseEntity<>(dataownerService.updateDataowner(dataowner),HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in updating the dataowner");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR DELETING THE DATAOWNER
    @DeleteMapping("/dataowner/{id}")
    private ResponseEntity<?> deleteDataowner(@PathVariable Long id)
    {
    HashMap<String,String> res= new HashMap<>();

        try
        {
            dataownerService.deleteDataowner(id);
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in deleting the dataowner");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
