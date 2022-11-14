package com.zabalotckialexey.testtaskh2db.controller;

import com.zabalotckialexey.testtaskh2db.model.Magazine;
import com.zabalotckialexey.testtaskh2db.service.MagazineService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/magazines")
@RequiredArgsConstructor
public class MagazineController {
    private final MagazineService magazineService;

    @GetMapping("/all")
    public List<Magazine> findAll() {
        return magazineService.getAllMagazines();
    }

    @PostMapping("/add")
    public ResponseEntity<Magazine> add(@RequestBody Magazine magazine) {
        if (magazine.getId() != null && magazine.getId() != 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (magazine.getEditor() == null || magazine.getEditor().trim().length() == 0) {
            return new ResponseEntity("missed param: editor", HttpStatus.NOT_ACCEPTABLE);
        }
        if (magazine.getTitle() == null || magazine.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        if (magazine.getPublisher() == null || magazine.getPublisher().trim().length() == 0) {
            return new ResponseEntity("missed param: publisher", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(magazineService.add(magazine));
    }

    @PutMapping("/update")
    public ResponseEntity<Magazine> update(@RequestBody Magazine magazine) {
        if (magazine.getId() == null || magazine.getId() == 0) {
            return new ResponseEntity("Error: id MUST be fill", HttpStatus.NOT_ACCEPTABLE);
        }
        if (magazine.getEditor() == null || magazine.getEditor().trim().length() == 0) {
            return new ResponseEntity("missed param: you MUST fill editor form", HttpStatus.NOT_ACCEPTABLE);
        }
        if (magazine.getTitle() == null || magazine.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: you MUST fill title form", HttpStatus.NOT_ACCEPTABLE);
        }

        magazineService.update(magazine);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Magazine> findById(@PathVariable Long id) {
        Magazine magazine = null;

        try {
            magazine = magazineService.findMagazineById(id);
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return new ResponseEntity("id: " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(magazine);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Magazine> deleteById(@PathVariable Long id) {
        try {
            magazineService.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
            return new ResponseEntity("That id: " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search-title")
    public ResponseEntity<List<Magazine>> search(@RequestParam("title") String title) {
        return ResponseEntity.ok(magazineService.findMagazineByTitle(title));
    }

    @PostMapping("/search-date")
    public ResponseEntity<List<Magazine>> searchDate(@RequestParam("date") String date) {
        return ResponseEntity.ok(magazineService.findMagazineByDate(date));
    }

    @PostMapping("/search-editor")
    public ResponseEntity<List<Magazine>> searchEditor(@RequestParam("editor") String editor) {
        return ResponseEntity.ok(magazineService.findMagazineByEditor(editor));
    }

    @PostMapping("/search-publisher")
    public ResponseEntity<List<Magazine>> searchPublisher(@RequestParam("publisher") String publisher) {
        return ResponseEntity.ok(magazineService.findBookByPublisher(publisher));
    }
}
