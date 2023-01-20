package com.davixmns.workshopmongodb.services;

import com.davixmns.workshopmongodb.domain.User;
import com.davixmns.workshopmongodb.dto.UserDTO;
import com.davixmns.workshopmongodb.repository.UserRepository;
import com.davixmns.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void deleteById(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj) {
        Optional<User> newObj = repository.findById(obj.getId());
        if (newObj.isPresent()) {
            updateData(newObj.get(), obj);
            return repository.save(newObj.get());
        } else{
            throw new ObjectNotFoundException("Object not found");
        }
    }

    public void updateData(User newObj, User obj){
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }


    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
