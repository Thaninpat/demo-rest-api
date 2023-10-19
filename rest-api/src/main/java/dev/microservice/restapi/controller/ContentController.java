package dev.microservice.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.microservice.restapi.model.Content;
import dev.microservice.restapi.repository.ContentCollectionRepositiry;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepositiry repositiry;

    public ContentController(ContentCollectionRepositiry repositiry) {
        this.repositiry = repositiry;

    }

    // make a request and find all the pieces of content in the system

    @GetMapping("")
    public List<Content> findAll() {
        return repositiry.findAll();
    }

    // CREATE READ UPDATE DELETE - filter | paging and sorting
    @GetMapping("/{id}")
    public Content findByID(@PathVariable Integer id) {
        return repositiry.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Create not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        repositiry.save(content);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repositiry.exitById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Create not found!");

        }
        repositiry.save(content);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repositiry.delete(id);
    }

}
