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

    @GetMapping("/{id}")
    public UserEntity userSearch(@PathVariable int id, @RequestBody UserEntity userEntity) {
         return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário com id " + id + " não localizado!")
        );
    }

    @PutMapping("/{id}")
    public UserEntity userUpdate(@PathVariable int id, @RequestBody UserEntity userEntity) {
        UserEntity user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário com id " + id + " não localizado!")
        );
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String  userDelete(@PathVariable int id){
        UserEntity user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário com id " + id + " não localizado!")
        );
        userRepository.delete(user);
        return "Usuário id "+user.getId()+", "+user.getName()+" excluído com sucesso!";
    }

}
