package pro.Sky.Skypro.model;

import java.util.*;

public class Constans {
    public static final String QUESTION1 = "question1";
    public static final String QUESTION2 = "question2";
    public static final String QUESTION3 = "question3";
    public static final String QUESTION4 = "question4";
    public static final String QUESTION5 = "question5";
    public static final String ANSWER1 = "answer1";
    public static final String ANSWER2 = "answer2";
    public static final String ANSWER3 = "answer3";
    public static final String ANSWER4 = "answer4";
    public static final String ANSWER5 = "answer5";
    public static final Question QUESTIONOBJ1 = new Question(QUESTION1, ANSWER1);
    public static final Question QUESTIONOBJ2 = new Question(QUESTION2, ANSWER2);
    public static final Question QUESTIONOBJ3 = new Question(QUESTION3, ANSWER3);
    public static final Question QUESTIONOBJ4 = new Question(QUESTION4, ANSWER4);
    public static final Question QUESTIONOBJ5 = new Question(QUESTION5, ANSWER5);

    public static final Set<Question> allQuestion = Set.of(
            QUESTIONOBJ1,
            QUESTIONOBJ2,
            QUESTIONOBJ3,
            QUESTIONOBJ4,
            QUESTIONOBJ5
    );
}
