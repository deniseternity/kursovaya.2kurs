package pro.Sky.Skypro.service;

import org.springframework.stereotype.Service;
import pro.Sky.Skypro.model.Constans;
import pro.Sky.Skypro.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Service
public class JavaQuestionService implements QuestionService {
    Random random = new Random();
    public List<Question> questions = new ArrayList<>();

    public Question getRandomQuestion(int maxCount){
int randomNumber = random.nextInt(0 , maxCount);
return questions.get(randomNumber);
    }

    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)) {
            throw new RuntimeException();
        }
        questions.add(question1);
        return question1;
    }

    public Question delete(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.remove(question1);
        return question1;
    }

    public List <Question> getAll() {
        return questions;
    }
}