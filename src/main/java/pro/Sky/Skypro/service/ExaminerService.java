package pro.Sky.Skypro.service;

import pro.Sky.Skypro.model.Question;

import java.util.List;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
