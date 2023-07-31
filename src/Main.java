public class Main {
    public static void main(String[] args) {

        // create a quiz (5 question)
        // create 5 questions from user
        // QuestionService : create, get, delete,
        // Array - String


        // Roles
        // Negative marking
        // realtime score
        // play again (different question)
        // skip question
        // set timer


        QuestionService service = new QuestionService();
        //service.displayQuestions();
        service.playQuiz();
        service.printScore();



    }
}