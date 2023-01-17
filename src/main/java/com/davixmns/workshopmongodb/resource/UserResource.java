package com.davixmns.workshopmongodb.resource;

import com.davixmns.workshopmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        return ResponseEntity.ok().body(Arrays.asList(maria, alex));
    }
}
