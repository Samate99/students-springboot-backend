package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    public StudentController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getStudents(Model model) {
        List<Student> listStudents = studentsRepository.findAll();
        model.addAttribute("listStudents",listStudents);
        return ResponseEntity.ok(listStudents);
    }

}


