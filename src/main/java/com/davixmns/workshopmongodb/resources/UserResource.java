package com.davixmns.workshopmongodb.resources;

import com.davixmns.workshopmongodb.domain.User;
import com.davixmns.workshopmongodb.dto.UserDTO;
import com.davixmns.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = service.findAll();
        List<UserDTO> userDTOS = users.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(userDTOS);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
