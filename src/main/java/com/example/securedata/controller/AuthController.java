package com.example.securedata.controller;

import com.example.securedata.Dto.LoginDto;
import com.example.securedata.service.IDataUserService;
import com.example.securedata.service.IDataownerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

       @Autowired
       private IDataownerService dataownerService;

       @Autowired
       private IDataUserService dataUserService;

    //ENDPOINT FOR ADMIN LOGIN
    @PostMapping("/adminlogin")
    private ResponseEntity<?> ownerLogin(@RequestBody LoginDto l)
    {
        HashMap<String,String> res=new HashMap<>();
        try
        {
            if(l.getEmail().equals("admin@gmail.com")&&l.getPassword().equals("admin"))
            {
                res.put("message","admin");
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
            res.put("error","invalid credentials");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch(Exception e)
        {
            res.put("error","invalid credentials");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/dataownerlogin")
    private ResponseEntity<?> dataownerlogin(@RequestBody LoginDto l)
    {
        HashMap<String,String> res=new HashMap<>();
        try
        {
            if(dataownerService.findByEmailAndPassword(l.getEmail(),l.getPassword())!=null)
            {
                res.put("message","dataowner");
                return new ResponseEntity<>(res,HttpStatus.OK);
            }
            res.put("error","invalid credentials");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch(Exception e)
        {
            res.put("error","error in login");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/datauserlogin")
    private ResponseEntity<?> datauserLogin(@RequestBody LoginDto l) {
        HashMap<String, String> res = new HashMap<>();
        try {


            if (dataUserService.FindByEmailAndPassword(l.getEmail(), l.getPassword()) != null) {
                res.put("message", "datauser");
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
            res.put("error", "invalid credentials");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e) {
            res.put("error", "invalid credentials");
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
