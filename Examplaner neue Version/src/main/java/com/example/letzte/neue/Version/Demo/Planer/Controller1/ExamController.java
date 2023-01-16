package com.example.letzte.neue.Version.Demo.Planer.Controller1;

import com.example.letzte.neue.Version.Demo.Planer.Database.Examrepository;
import com.example.letzte.neue.Version.Demo.Planer.Modal.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/examcontroller")
public class ExamController {
    @Autowired
    private Examrepository cr;


    @RequestMapping (method = RequestMethod.GET, path = "/getallexam")
    public @ResponseBody ArrayList<Exam> getAllExams() // ArrayList<Exam>
    {
        ArrayList<Exam> all = new ArrayList<>(); // funktioniert das, weil könnte auch List vor dem Generic stehen
        for (Exam exams : cr.findAll()) {
            all.add(exams);
        }
        return all;
    }

    @PostMapping(path = "/insertExams")
    public @ResponseBody ResponseEntity addExam(@RequestParam String name, String subject, String room)
    {
        Exam a = new Exam();
        a.setText(name);
        a.setRoom(room);
        a.setSubject(subject);
        cr.save(a);
        //return "ok";
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping (path = "/testexam")
    public @ResponseBody ResponseEntity testexam ()
    {
        Exam a = new Exam();
        a.setText("set");
        a.setRoom("room");
        a.setSubject("subject");
        cr.save(a);
        //return "ok";
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
// Response Body vs. Request Body
// Warum autowired
// wie funktioniert das mit crustrepository
// Request Param -> Requestbody

