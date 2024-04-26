package pro.Sky.Skypro.service;

import pro.Sky.Skypro.exception.AmountMoreThanQuestionsQuantityException;
import pro.Sky.Skypro.model.Question;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private final QuestionService javaQuestionService;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestions") QuestionService questionService) {
        this.javaQuestionService = questionService;
        this.random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questionsSetForExam = new HashSet<>();
        Collection<Question> allQuestions = javaQuestionService.getAll();;
        int totalQuestions = allQuestions.size();
        if (amount > totalQuestions) {
            throw new AmountMoreThanQuestionsQuantityException("Запрос превышает фактическое количество содержимого");
        }
        while (amount > 0) {
            Question randomQuestion = getRandomUniqueQuestion(allQuestions);
            if (!questionsSetForExam.contains(randomQuestion)) {
                questionsSetForExam.add(randomQuestion);
                amount--;
            } else {
                continue;
            }
        }
        return questionsSetForExam;
    }

    private Question getRandomUniqueQuestion(Collection<Question> allQuestion) {
        int totalQuestions = allQuestion.size();
        int randomIndex = random.nextInt(totalQuestions);
        List<Question> allQuestionList = new ArrayList<>(allQuestion);
        Question uniqueQuestion = allQuestionList.get(randomIndex);
        return uniqueQuestion;
    }
}
