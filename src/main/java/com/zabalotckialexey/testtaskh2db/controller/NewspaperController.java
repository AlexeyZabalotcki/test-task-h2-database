package com.zabalotckialexey.testtaskh2db.controller;

import com.zabalotckialexey.testtaskh2db.model.Newspaper;
import com.zabalotckialexey.testtaskh2db.service.NewspaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/newspapers")
@RequiredArgsConstructor
public class NewspaperController {
    private final NewspaperService newspaperService;

    @GetMapping("/all")
    public List<Newspaper> findAll() {
        return newspaperService.getAllNewspapers();
    }

    @PostMapping("/add")
    public ResponseEntity<Newspaper> add(@RequestBody Newspaper newspaper) {
        if (newspaper.getId() != null && newspaper.getId() != 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (newspaper.getAuthor() == null || newspaper.getAuthor().trim().length() == 0) {
            return new ResponseEntity("missed param: author", HttpStatus.NOT_ACCEPTABLE);
        }
        if (newspaper.getTitle() == null || newspaper.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        if (newspaper.getPublisher() == null || newspaper.getPublisher().trim().length() == 0) {
            return new ResponseEntity("missed param: publisher", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(newspaperService.add(newspaper));
    }

    @PutMapping("/update")
    public ResponseEntity<Newspaper> update(@RequestBody Newspaper newspaper) {
        if (newspaper.getId() == null || newspaper.getId() == 0) {
            return new ResponseEntity("Error: id MUST be fill", HttpStatus.NOT_ACCEPTABLE);
        }
        if (newspaper.getAuthor() == null || newspaper.getAuthor().trim().length() == 0) {
            return new ResponseEntity("missed param: you MUST fill author form", HttpStatus.NOT_ACCEPTABLE);
        }
        if (newspaper.getTitle() == null || newspaper.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: you MUST fill title form", HttpStatus.NOT_ACCEPTABLE);
        }

        newspaperService.update(newspaper);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Newspaper> findById(@PathVariable Long id) {
        Newspaper newspaper = null;

        try {
            newspaper = newspaperService.findNewspaperById(id);
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return new ResponseEntity("id: " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(newspaper);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Newspaper> deleteById(@PathVariable Long id) {
        try {
            newspaperService.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
            return new ResponseEntity("That id: " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Newspaper>> search(@RequestParam("title") String title) {
        return ResponseEntity.ok(newspaperService.findNewspaperByTitle(title));
    }
}
