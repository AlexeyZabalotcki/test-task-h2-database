package com.zabalotckialexey.testtaskh2db.service;

import com.zabalotckialexey.testtaskh2db.model.Newspaper;
import com.zabalotckialexey.testtaskh2db.repository.NewspaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewspaperService {
    private final NewspaperRepository newspaperRepository;

    public List<Newspaper> getAllNewspapers() {
        return newspaperRepository.findAll();
    }

    public Newspaper findNewspaperById(Long id) {
        return newspaperRepository.findById(id).get();
    }

    public List<Newspaper> findNewspaperByTitle(String title) {
        return newspaperRepository.findByTitleContains(title);
    }

    public List<Newspaper> findNewspaperByDate(String date) {
        return newspaperRepository.findAllByPublicationDateContaining(date);
    }

    public List<Newspaper> findNewspaperByAuthor(String author) {
        return newspaperRepository.findAllByAuthorContains(author);
    }

    public List<Newspaper> findBookByPublisher(String publisher) {
        return newspaperRepository.findByPublisherContains(publisher);
    }

    public Newspaper add(Newspaper newspaper) {
        return newspaperRepository.save(newspaper);
    }

    public Newspaper update(Newspaper newspaper) {
        return newspaperRepository.save(newspaper);
    }

    public void deleteById(Long id) {
        newspaperRepository.deleteById(id);
    }
}
