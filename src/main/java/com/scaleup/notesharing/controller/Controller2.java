package com.scaleup.notesharing.controller;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.scaleup.notesharing.models.Branch;
import com.scaleup.notesharing.models.City;
import com.scaleup.notesharing.models.College;
import com.scaleup.notesharing.models.Note;
import com.scaleup.notesharing.models.Role;
import com.scaleup.notesharing.models.Student;
import com.scaleup.notesharing.models.Subject;
import com.scaleup.notesharing.models.University;
import com.scaleup.notesharing.repositores.BranchRepository;
import com.scaleup.notesharing.repositores.CityRepository;
import com.scaleup.notesharing.repositores.CollegeRepository;
import com.scaleup.notesharing.repositores.NoteRepository;
import com.scaleup.notesharing.repositores.RoleRepository;
import com.scaleup.notesharing.repositores.StudentRepository;
import com.scaleup.notesharing.repositores.SubjectRepository;
import com.scaleup.notesharing.repositores.UniversityRepository;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

@RestController
@RequestMapping("/dev_test")
public class Controller2 {

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
    @Autowired
    private BranchRepository branchRepository;

    @GetMapping("/populateDB")
    public String populateDB()
    {
        roleRepository.deleteAll();
        studentRepository.deleteAll();
        noteRepository.deleteAll();
        subjectRepository.deleteAll();
        branchRepository.deleteAll();
        collegeRepository.deleteAll();
        universityRepository.deleteAll();
        cityRepository.deleteAll();

        City city1 = new City("Bangalore");
        cityRepository.save(city1);

        University university1 = new University.Builder()
                .name("pune")
                .officeIn(city1)
                .build();
        universityRepository.save(university1);

        College c1 = new College.Builder()
                .name("IITM")
                .city(city1)
                .university(university1)
                .build();
        collegeRepository.save(c1);

        Branch br = new Branch("computer");
        branchRepository.save(br);

        Student student1 = new Student.Builder()
                .name("sarang")
                .branch(br)
                .college(c1)
                .email("bagadesarang@gmail.com")
                .saltedHashedPassword("abcd")
                .build();
        studentRepository.save(student1);

        Note note1 = new Note.Builder()
                .name("note1")
                .description("first note")
                .price(100)
                .student(student1)
                .build();
        noteRepository.save(note1);
        Note note2 = new Note.Builder()
                .name("note2")
                .description("second note")
                .price(200)
                .student(student1)
                .build();
        noteRepository.save(note2);

        Subject subject1 = new Subject.Builder()
                .name("spring")
                .branch(br)
                .build();
        subjectRepository.save(subject1);

        return "DB populated";
    }

    @GetMapping("/getAllNotes")
    public List<Note> getAllNotes()
    {
        List<Note> notes = noteRepository.findAll();
        for (Note note:notes)
        {
            System.out.println(note.getName());
        }
        return notes;
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

//    @RequestMapping(value = "/postRequest", method = RequestMethod.POST)
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check(@RequestParam Integer id, @RequestParam String[] name)
    {
        System.out.println(name[1]);
        return Integer.toString(id);
    }
}
