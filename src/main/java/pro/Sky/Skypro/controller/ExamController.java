package pro.Sky.Skypro.controller;

import pro.Sky.Skypro.model.Question;
import pro.Sky.Skypro.service.ExaminerService;
import pro.Sky.Skypro.service.ExaminerServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")

public class ExamController {

    private ExaminerService service;

    @Autowired
    public ExamController (ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return service.getQuestions(amount);
    }
}