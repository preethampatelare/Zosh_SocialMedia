package com.Zosh.project_1;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class rc{

    @Autowired
    userRepo ur;

    @PostMapping("rc/adduser")
    public User addUser(@RequestBody User use){
        System.out.println(use.getFirstName());
        User savedRepo = ur.save(use);
        return savedRepo;
    }

    @GetMapping("rc/AllUsers")
    public List<User> getAllUsers(){
        List<User> list = ur.findAll();
        return list;
    }

    @GetMapping("rc/Rubi/{id}")
    public User getById(@PathVariable Integer id) throws Exception{
        Optional<User> list = ur.findById(id);
        if(list.isPresent()){
            return list.get();
        }
        throw new Exception("User not exist: "+ id);
    }

    @PutMapping("rc/updateUser/{id}")
    public User updateUser(@RequestBody User rb , @PathVariable Integer id) throws Exception {
        Optional<User> p = ur.findById(id);
        if(p.isEmpty()){
            throw new Exception("User not Exist"+id);
        }
        User old = p.get();
        if(rb.getFirstName() !=null){
            old.setFirstName(rb.getFirstName());
        }
        if(rb.getLastName() !=null){
            old.setLastName(rb.getLastName());
        }
        if(rb.getEmail() !=null){
            old.setEmail(rb.getEmail());
        }
        if(rb.getPassword() !=null){
            old.setPassword(rb.getPassword());
        }
        ur.save(old);
        return old;
    }

    @DeleteMapping("rc/deleteById/{id}")
    public String deleteUserById(@PathVariable Integer id) throws Exception{
        Optional<User> p = ur.findById(id);
        if(p.isEmpty()){
            throw new Exception("User not found with id: "+id);
        }
        ur.delete(p.get());
        return ("deleted user with id: "+id);
    }
}