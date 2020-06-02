package com.scaleup.notesharing;

import com.scaleup.notesharing.models.*;
import com.scaleup.notesharing.repositores.*;
import jdk.jshell.Snippet;
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
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UniversityRepository universityRepository;


    @GetMapping("/populateDB")
    public String populateDB()
    {
        roleRepository.deleteAll();
        studentRepository.deleteAll();
        noteRepository.deleteAll();
        subjectRepository.deleteAll();
        collegeRepository.deleteAll();
        universityRepository.deleteAll();
        cityRepository.deleteAll();

        City city1 = City.builder().name("Chennai").build();
        cityRepository.save(city1);

        University university1 = University.builder().name("pune").officeIn(city1).build();
        universityRepository.save(university1);

        College c1 = College.builder().name("IITM").city(city1).university(university1).build();
        collegeRepository.save(c1);

        Student student1 = Student.builder().name("sarang").branch(Branch.COMPUTER).college(c1).build();
        studentRepository.save(student1);

        Note note1 = Note.builder().name("note1").description("first note").price(100).student(student1).build();
        noteRepository.save(note1);
        Note note2 = Note.builder().name("note2").description("second note").price(200).student(student1).build();
        noteRepository.save(note2);

        Subject subject1 = Subject.builder().name("spring").build();
        subjectRepository.save(subject1);

        return "DB populated";
    }

    @GetMapping("/getAllNotes")
    public List<Note> getAllNotes()
    {
        return noteRepository.findAll();
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }
    @GetMapping("/getAllCities")
    public List<City> getAllCities()
    {
        return cityRepository.findAll();
    }
    @GetMapping("/getAllUniversities")
    public List<University> getAllUniversities()
    {
        return universityRepository.findAll();
    }
    @GetMapping("/getAllSubjects")
    public List<Subject> getAllSubjects()
    {
        return subjectRepository.findAll();
    }
    @GetMapping("/getAllRoles")
    public List<Role> getAllRoles()
    {
        return roleRepository.findAll();
    }

    @GetMapping("/")
    public String hello()
    {
        return "hello world";
    }
}
