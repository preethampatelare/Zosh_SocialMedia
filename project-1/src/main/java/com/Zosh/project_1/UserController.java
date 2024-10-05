package com.Zosh.project_1;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    List<User> list = new ArrayList<>();
    int ite = 1;
    @GetMapping("AllUser")
    public List<User> users(){
        User user = new User(1,"Shashi","Preetham","areshashi@gmail.com","987654321");
        list.add(user);
        return list;
    }
}
