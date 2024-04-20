package pro.Sky.Skypro;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.Sky.Skypro.model.Question;
import pro.Sky.Skypro.service.JavaQuestionService;

import java.util.*;
import java.util.stream.Stream;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private Random random;
    @InjectMocks
    private JavaQuestionService out;


    static Stream<Arguments> argumentsStream() {
        return Stream.of(Arguments.of("Question", "Answer"));
    }

    static Stream<Arguments> questionsProvider() {
        return Stream.of(Arguments.of(
                new Question("Question1", "Answer1"),
                new Question("Question2", "Answer2"),
                new Question("Question3", "Answer3")));
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void addTest(String question, String answer) {
        Set<Question> questionSetWithObject = new HashSet<>();
        Question result = new Question(question, answer);
        questionSetWithObject.add(result);
    }
}
