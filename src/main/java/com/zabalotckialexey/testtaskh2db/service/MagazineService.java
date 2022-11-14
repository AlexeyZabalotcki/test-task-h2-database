package com.zabalotckialexey.testtaskh2db.service;

import com.zabalotckialexey.testtaskh2db.model.Magazine;
import com.zabalotckialexey.testtaskh2db.repository.MagazineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MagazineService {
    private final MagazineRepository magazineRepository;

    public List<Magazine> getAllMagazines() {
        return magazineRepository.findAll();
    }

    public Magazine findMagazineById(Long id) {
        return magazineRepository.findById(id).get();
    }

    public List<Magazine> findMagazineByTitle(String title) {
        return magazineRepository.findByTitle(title);
    }

    public List<Magazine> findMagazineByEditor(String editor) {
        return magazineRepository.findByEditor(editor);
    }

    public List<Magazine> findBookByPublisher(String publisher) {
        return magazineRepository.findByPublisher(publisher);
    }

    public List<Magazine> findMagazineByDate(String date) {
        return magazineRepository.findByPublicationDate(date);
    }

    public Magazine add(Magazine magazine) {
        return magazineRepository.save(magazine);
    }

    public Magazine update(Magazine magazine) {
        return magazineRepository.save(magazine);
    }

    public void deleteById(Long id) {
        magazineRepository.deleteById(id);
    }
}
