package pro.Sky.Skypro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.Sky.Skypro.exception.AmountMoreThanQuestionsQuantityException;
import pro.Sky.Skypro.model.Question;
import pro.Sky.Skypro.service.ExaminerServiceImpl;
import pro.Sky.Skypro.service.JavaQuestionService;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Mock
    private JavaQuestionService questionService;


    @Test
    public void test() {
        List<Question> test1 = new ArrayList<>();
        test1.add(new Question("вопрос1", "ответ2"));
        when(questionService.getAll()).thenReturn(test1);
        //test
        Collection<Question> questions = examinerService.getQuestions(1);
        //check
        assertThat(questions).containsAll(test1);
    }

    @Test
    public void test2() {
        List<Question> test1 = new ArrayList<>();
        test1.add(new Question("вопрос1", "ответ2"));
        when(questionService.getAll()).thenReturn(test1);
        //test
        assertThrows(AmountMoreThanQuestionsQuantityException.class, () -> examinerService.getQuestions(2));
    }

    @Test
    public void test3() {
        List<Question> test1 = new ArrayList<>();
        test1.add(new Question("вопрос1", "ответ2"));
        when(questionService.getAll()).thenReturn(test1);
        //test
        Collection<Question> questions = examinerService.getQuestions(0);
        //check
        assertThat(questions).isEmpty();
    }
}
