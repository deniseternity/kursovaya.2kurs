package pro.Sky.Skypro.service;

import org.springframework.stereotype.Service;
import pro.Sky.Skypro.model.Question;

import java.util.Collection;

public interface QuestionService {

     Question add(String question, String answer);

    Question delete(String question, String answer);

    Collection <Question> getAll();
}
