import java.util.Scanner;
import java.util.Timer;

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

        /*long delay = 10;
        long timer System.currentTimeMillis()+delay;*/
        Player player = null;
        boolean playAgain = true;
        System.out.println("###############################################################");
        System.out.println("                       Welcome to QuizApp                      ");
        System.out.println("###############################################################");
        System.out.println("Choose your option: ");
        System.out.println("Trainer --> Enter 1.");
        System.out.println("Player -->  Enter 2.");
        Scanner roleInput = new Scanner(System.in);
        int role = roleInput.nextInt();
        if (role == 1) {
            //todo : implement code to create the quiz and start the quiz by trainer.
        } else if (role == 2) {
            System.out.println("Please enter your name: ");
            Scanner NameInput = new Scanner(System.in);
            String name = NameInput.next();
            player = new Player(name);

            System.out.println("##########################################################################");
            System.out.println("Please read the Quiz rules:  ");
            System.out.println("**There are total 5 questions and Time limit is 7 minutes.");
            System.out.println("**You have the option to skip the question if you do not want to answer.");
            System.out.println("**1 point will be deducted from your score for each wrong answer.");
            System.out.println("##########################################################################");
            System.out.println(player.getName() + " Please select the topic for your quiz from the below options:");
            System.out.println("1.Navin Reddy");
            System.out.println("2.Core java programming");
           /* long totalTime=120000;
            long timer;*/
            Scanner topicInput = new Scanner(System.in);
            int topic = topicInput.nextInt();
            do {

                if (topic == 1) {
                    QuestionService service = new QuestionService(1);
                     //timer= System.currentTimeMillis()+totalTime;
                    //System.out.println("Current time is : "+System.currentTimeMillis());
                    // while(System.currentTimeMillis() <timer) {
                         service.playQuiz(player);
                     //}
                   // System.out.println("Timeout");
                } else {
                    if (topic == 2) {
                        QuestionService service = new QuestionService(2);
                        service.playQuiz(player);
                    }
                }
                //service.displayQuestions();
                // service.printScore();
               // System.out.println("Current time is : "+System.currentTimeMillis());
                System.out.println("Do you want to play again?Y/N : ");

                Scanner tryAgain = new Scanner(System.in);
                String ready = tryAgain.next();
                if (ready != null && ready.equalsIgnoreCase("Y")) {
                    playAgain = true;
                } else {
                    playAgain = false;
                }


            } while (playAgain);
            if (null != player) {
                System.out.println(player.getName() + " Hope you enjoyed the quiz!!! See you again");
            }


        }
    }

}
