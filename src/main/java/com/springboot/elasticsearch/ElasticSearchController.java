package com.springboot.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ElasticSearchController {

    @Autowired
    private ElasticSearchQuery elasticSearchQuery;

    @PostMapping("/employee")
    public ResponseEntity<Object> createOrUpdateDocument(@RequestBody Employee employee) throws IOException {
        String response = elasticSearchQuery.createOrUpdateDocument(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Object> getDocumentById(@PathVariable String empId) throws IOException {
        Employee employee =  elasticSearchQuery.getDocumentById(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<Object> deleteDocumentById(@PathVariable String empId) throws IOException {
        String response =  elasticSearchQuery.deleteDocumentById(empId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> searchAllDocument() throws IOException {
        List<Employee> employees = elasticSearchQuery.searchAllDocuments();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
