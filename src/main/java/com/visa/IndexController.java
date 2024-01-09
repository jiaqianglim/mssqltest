package com.visa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class IndexController {

    @Autowired
    MSSQLRepo mssqlRepo;

    @GetMapping("/index")
    public ResponseEntity<String> getIndex() throws JsonProcessingException {

        List<User> user = mssqlRepo.getUsers();
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(user);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(body);
    }
}
