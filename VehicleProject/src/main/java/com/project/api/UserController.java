package com.project.api;

import java.util.Date;
import java.util.List;

import com.project.util.BindingErrorsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.project.bean.Users;
import com.project.service.UserService;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> listUser() {
        logger.info("> Stating list User");

        List<Users> list = userService.listUsers();

        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/list-id-users/{idUsers}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> listIdUser(@PathVariable("idUsers") Integer idUsers) {
        logger.info("> Stating list User for id");

        List<Users> list = userService.listIdUser(idUsers);

        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> registerUsers(@RequestBody Users user, BindingResult bindingResult,
                                               UriComponentsBuilder ucBuilder) {
        logger.info("> Stating Create User", user);
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();

        if (bindingResult.hasErrors() || user == null) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        userService.registerUsers(user);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> updateUsers(@RequestBody Users user, BindingResult bindingResult,
                                             UriComponentsBuilder ucBuilder) {
        logger.info("Update User", user);

        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();

        if (bindingResult.hasErrors() || user == null) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        userService.updateUsers(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-users/{idUsers}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> deleteUsers(@PathVariable("idUsers") Integer idUsers) {
        logger.info("Delete User", idUsers);

        userService.deleteUsers(idUsers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
