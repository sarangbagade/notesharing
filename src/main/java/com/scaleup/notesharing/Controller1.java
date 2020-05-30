package com.scaleup.notesharing;

import com.scaleup.notesharing.models.*;
import com.scaleup.notesharing.repositores.CityRepository;
import com.scaleup.notesharing.repositores.CollegeRepository;
import com.scaleup.notesharing.repositores.NoteRepository;
import com.scaleup.notesharing.repositores.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dev_test")
public class Controller1 {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CollegeRepository collegeRepository;

    @GetMapping("/populateDB")
    public String populateDB()
    {
        noteRepository.deleteAll();
        studentRepository.deleteAll();
        collegeRepository.deleteAll();
        cityRepository.deleteAll();

        City city1 = City.builder().name("Chennai").build();
        cityRepository.save(city1);

        College c1 = College.builder().name("IITM").city(city1).build();
        collegeRepository.save(c1);

        Student student1 = Student.builder().name("sarang").branch(Branch.COMPUTER).college(c1).build();
        studentRepository.save(student1);

        Note note1 = Note.builder().name("note1").description("first note").price(100).student(student1).build();
        noteRepository.save(note1);

        return "DB populated";
    }

    @GetMapping("/getAllNotes")
    public List<Note> getAllNotes()
    {
        return noteRepository.findAll();
    }

    @GetMapping("/")
    public String hello()
    {
        return "hello world";
    }
}
