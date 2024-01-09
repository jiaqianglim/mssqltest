package com.visa;

import java.io.IOException;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping("/api")
public class JsonAPIController {

    @Autowired
    RestTemplate temp;

    Logger logger = LoggerFactory.getLogger(JsonAPIController.class);

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() throws IOException {

        logger.info("method invoked");

        RequestEntity req = RequestEntity
                .get("https://jsonplaceholder.typicode.com/users/1")
                .accept(MediaType.APPLICATION_JSON)
                .build();
        ResponseEntity<String> resp = temp.exchange(req, String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(resp.getBody().toString());
    }

}
