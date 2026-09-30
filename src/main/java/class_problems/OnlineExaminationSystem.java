package week8.class_problems;

import java.util.*;

abstract class Question3 {
    String questionId;
    int points;

    Question3(String questionId, int points) {
        this.questionId = questionId;
        this.points = points;
    }

    abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question3 {
    String correctOption;

    MultipleChoiceQuestion(String questionId, int points, String correctOption) {
        super(questionId, points);
        this.correctOption = correctOption;
    }

    @Override
    boolean evaluate(String answer) {
        return correctOption.equals(answer);
    }
}

class TrueFalseQuestion extends Question3 {
    boolean correctAnswer;

    TrueFalseQuestion(String questionId, int points, boolean correctAnswer) {
        super(questionId, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    boolean evaluate(String answer) {
        return String.valueOf(correctAnswer).equalsIgnoreCase(answer);
    }
}

class Attempt {
    String studentName;
    String examName;
    Map<Question3, String> answers = new LinkedHashMap<>();
    String state = "InProgress";

    Attempt(String studentName, String examName) {
        this.studentName = studentName;
        this.examName = examName;
        System.out.println(examName + " started by " + studentName);
    }

    void recordAnswer(Question3 question, String answer) {
        if (!state.equals("InProgress")) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        answers.put(question, answer);
        System.out.println("Answer recorded for " + question.questionId);
    }

    void submit() {
        state = "Submitted";
        System.out.println(examName + " submitted by " + studentName);
        int total = 0, maxTotal = 0;
        StringBuilder result = new StringBuilder("Result: ");
        int i = 0;
        for (Map.Entry<Question3, String> entry : answers.entrySet()) {
            Question3 q = entry.getKey();
            boolean correct = q.evaluate(entry.getValue());
            int scored = correct ? q.points : 0;
            total += scored;
            maxTotal += q.points;
            result.append(q.questionId).append(": ").append(correct ? "Correct" : "Incorrect").append(" (").append(scored).append(" points)");
            i++;
            if (i != answers.size()) result.append(", ");
        }
        result.append(". Total score: ").append(total).append("/").append(maxTotal);
        System.out.println(result);
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("Question 1", 5, "C");
        TrueFalseQuestion q2 = new TrueFalseQuestion("Question 2", 5, false);

        Attempt attempt = new Attempt("Student 1", "Exam A");
        attempt.recordAnswer(q1, "C");
        attempt.recordAnswer(q2, "true");
        attempt.submit();
        attempt.recordAnswer(q1, "A");
    }
}