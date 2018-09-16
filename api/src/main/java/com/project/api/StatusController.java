package com.project.api;

import com.project.bean.Status;
import com.project.service.StatusService;
import com.project.util.BindingErrorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping(value = "/list-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Status>> listStatus() {

        List<Status> list = statusService.findAll();

        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Status>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/list-id-status/{idStatus}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> listIdStatus(@PathVariable("idStatus") Integer idStatus) {
        Status list = statusService.findById(idStatus);

        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Status>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> registerUsers(@RequestBody Status status, BindingResult bindingResult,
                                                UriComponentsBuilder ucBuilder) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();

        if (bindingResult.hasErrors() || status == null) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        statusService.create(status);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> updateUsers(@RequestBody Status status, BindingResult bindingResult,
                                              UriComponentsBuilder ucBuilder) {

        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();

        if (bindingResult.hasErrors() || status == null) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        statusService.update(status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-status/{idStatus}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> deleteUsers(@PathVariable("idStatus") Integer idStatus) {
        statusService.delete(idStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
