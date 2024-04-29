package pro.Sky.Skypro;
import org.apache.catalina.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.Sky.Skypro.model.Question;
import pro.Sky.Skypro.service.JavaQuestionService;
import pro.Sky.Skypro.service.QuestionService;

import java.util.*;
import java.util.stream.Stream;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
//    @Mock
//    private Random random;


    @InjectMocks
    private JavaQuestionService out;

    static Stream<Arguments> argumentsStream() {
        return Stream.of(Arguments.of(
                new Question("Question1", "Answer1"),
                new Question("Question2", "Answer2"),
                new Question("Question3", "Answer3")));
    }

    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void addTest(Question question) {
        Question actual = javaQuestionService.add(question.getQuestion(), question.getAnswer());
        Assertions.assertEquals(actual,question);
        Assertions.assertTrue(javaQuestionService.questions.contains(actual));
    }
}

//@Service
//public class JavaQuestionService implements QuestionService {
//    List<Question> questions = new ArrayList<>();
//
//    public Question getRandomQuestion(int maxCount){
//        int randomNumber = new Random().nextInt(0 , maxCount);
//        return questions.get(randomNumber);
//    }
//
//    public Question add(String question, String answer) {
//        Question question1 = new Question(question, answer);
//        if (questions.contains(question1)) {
//            throw new RuntimeException();
//        }
//        questions.add(question1);
//        return question1;
//    }
//
//    public Question delete(String question, String answer) {
//        Question question1 = new Question(question, answer);
//        questions.remove(question1);
//        return question1;
//    }
//
//    public List <Question> getAll() {
//        return questions;
//    }
//}
