package pro.Sky.Skypro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.Sky.Skypro.model.Question;
import pro.Sky.Skypro.service.JavaQuestionService;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(String question, String answer) {
        return javaQuestionService.add(question,answer);
    }

    @GetMapping("/remove")
    public Question delete(String question, String answer) {
        return javaQuestionService.delete(question,answer);
    }

@GetMapping
    public List<Question> find() {
    return javaQuestionService.getAll();
}
}
