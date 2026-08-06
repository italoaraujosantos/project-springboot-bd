package br.com.isac.projectspringbootbd.controller;

import br.com.isac.projectspringbootbd.entity.UserEntity;
import br.com.isac.projectspringbootbd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public UserEntity userSave(@RequestBody UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @GetMapping
    public List<UserEntity> userList() {
        return userRepository.findAll();
    }



}
