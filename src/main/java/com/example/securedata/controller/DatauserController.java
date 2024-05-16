package com.example.securedata.controller;


import com.example.securedata.modal.Datauser;
import com.example.securedata.service.impl.DatauserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class DatauserController {

      @Autowired
    private DatauserService dataUserService;

    //ENDPOINT FOR ADDING THE DATAUSER
    @PostMapping("/datauser")
    private ResponseEntity<?> addDatauser(@RequestBody Datauser datauser)
    {
        HashMap<String,String> res=new HashMap<>();
        try
        {
            return new ResponseEntity<>(dataUserService.addDatauser(datauser), HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in adding the datauser");
             return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ENDPOINT FOR GETTING THE DATAUSER
    @GetMapping("/datauser")
    private ResponseEntity<?> getDatauser()
    {
        HashMap<String,String> res=new HashMap<>();
        try
        {
            return new ResponseEntity<>(dataUserService.getDatauser(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in getting all the datausers");
           return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ENDPPOINT FOR GETTING THE DATAUSER BY ID
    @GetMapping("/datauser/{id}")
    private ResponseEntity<?> getDataUserById(@PathVariable Long id)
    {
        HashMap<String,String> res=new HashMap<>();

        try
        {
            return  new ResponseEntity<>(dataUserService.getDatauserById(id),HttpStatus.OK);
        }
        catch(Exception e)
        {
            res.put("error","error in getting datauser");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ENDPOINT FOR UPDATING THE DATAUSER
    @PutMapping("/datauser")
   private ResponseEntity<?> updateDatauser(@RequestBody Datauser datauser)
   {
       HashMap<String,String> res=new HashMap<>();

       try
       {
           return new ResponseEntity<>(dataUserService.updateDatauser(datauser),HttpStatus.OK);
       }
       catch(Exception e)
       {
           res.put("error","error in updating the datauser");
           return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }


   //ENDPOINT FOR DELETING THE DATAUSER
   @DeleteMapping("/datauser/{id}")
    private ResponseEntity<?> deleteDatauser(@PathVariable Long id)
   {
       HashMap<String,String> res=new HashMap<>();
       try
       {
           dataUserService.deleteDatauser(id);
           return new ResponseEntity<>("deleted successfully",HttpStatus.INTERNAL_SERVER_ERROR);
       }
       catch(Exception e)
       {
            res.put("error","error in deleting the datauser");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

}
