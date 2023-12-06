package com.bci.ejercicio.demo.controller;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bci.ejercicio.demo.domain.entity.User;
import com.bci.ejercicio.demo.service.UserService;
import com.bci.ejercicio.demo.utils.ErrorManager;

@RestController
public class AppController {
    
    private final UserService userService;

    public AppController(UserService userService){
        this.userService = userService;
    }

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public Optional<User> singUp(@RequestBody User user){
        
        String response = ""; 

        if(!user.getPassword().matches("^(?=.*[A-Z])(?=(?:[^0-9]*[0-9]){2})[a-zA-Z0-9]{8,12}$")){
            ErrorManager error = new ErrorManager();
            error.setCodigo(1);
            error.setTimestamp(null);
            response = errorManager(, 1, "Debe tener solo una Mayúscula y solamente dos números (no necesariamente consecutivos), en combinación de letras minúsculas, largo máximo de 12 y mínimo 8.").toString();
        }
        if(user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            response = errorManage(new Timestamp(System.currentTimeMillis()), 1, "Debe tener solo una Mayúscula y solamente dos números (no necesariamente consecutivos), en combinación de letras minúsculas, largo máximo de 12 y mínimo 8.").toString();
        }else{
            User user2 = userService.signUp(user);
            response = user2.toString();
        }
        return user;
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public Optional<User> getBody(@RequestParam String username, @RequestParam String password){
        Optional user = userService.getUser(username, password);
        return user;
    }

}
