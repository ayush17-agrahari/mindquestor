import java.util.ArrayList;
import java.util.Scanner;

// Question class to represent each quiz question
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

// Quiz class to manage the quiz
class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());

            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            System.out.print("Your answer (1-" + options.length + "): ");
            int answer = scanner.nextInt() - 1;

            if (question.isCorrect(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + options[question.getCorrectAnswerIndex()] + "\n");
            }
        }
        
        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score + " out of " + questions.size());
        
        scanner.close();
    }
}

// Main class to run the quiz application
public class OnlineQuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Sample questions
        quiz.addQuestion(new Question(
            "What is the capital of France?",
            new String[]{"Berlin", "Paris", "Rome", "Madrid"},
            1
        ));
        quiz.addQuestion(new Question(
            "What is 5 + 7?",
            new String[]{"10", "11", "12", "13"},
            2
        ));
        quiz.addQuestion(new Question(
            "Who wrote 'To Kill a Mockingbird'?",
            new String[]{"Harper Lee", "Mark Twain", "Ernest Hemingway", "J.K. Rowling"},
            0
        ));

        // Start the quiz
        quiz.start();
    }
}

