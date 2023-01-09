package com.example.letzte.neue.Version.Demo.Planer.Database;



import com.example.letzte.neue.Version.Demo.Planer.Modal.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Examrepository extends CrudRepository<Exam, Long> {
    @Override
    @Query ("select a from Exam a")
    Iterable <Exam> findAll();
}
