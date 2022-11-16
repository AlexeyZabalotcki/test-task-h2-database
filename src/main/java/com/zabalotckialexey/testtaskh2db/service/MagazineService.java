package com.zabalotckialexey.testtaskh2db.service;

import com.zabalotckialexey.testtaskh2db.model.Magazine;
import com.zabalotckialexey.testtaskh2db.repository.MagazineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return magazineRepository.findByTitleContains(title);
    }

    public List<Magazine> findMagazineByEditor(String editor) {
        return magazineRepository.findAllByEditorContains(editor);
    }

    public List<Magazine> findBookByPublisher(String publisher) {
        return magazineRepository.findByPublisherContains(publisher);
    }

    public List<Magazine> findMagazineByDate(String date) {
        return magazineRepository.findAllByPublicationDateContaining(date);
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
