import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

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

        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal= Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        Player player = null;
        boolean playAgain = true;
        System.out.println("###############################################################");
        System.out.println("                       Welcome to QuizApp                      ");
        System.out.println("###############################################################");
        System.out.println("Choose your option: ");
        System.out.println("Trainer --> Enter 1.");
        System.out.println("Player -->  Enter 2.");
        Scanner input = new Scanner(System.in);
        int role = input.nextInt();
        if (role == 1) {
            //todo : implement code to create the quiz and start the quiz by trainer.

                System.out.println(" //todo :still working on implementing code to create the quiz and start the quiz by trainer. ");
                System.out.println("Please start again");

        } else if (role == 2) {
            System.out.println("Please enter your name: ");
            //Scanner NameInput = new Scanner(System.in);
            String name = input.next();
            player = new Player(name);

            System.out.println("##########################################################################");
            System.out.println("Please read the Quiz rules:  ");
            System.out.println("**There are total 5 questions and Time limit for each question is 15 seconds.");
            System.out.println("**You have the option to skip the question if you do not want to answer.");
            System.out.println("**1 point will be deducted from your score for each wrong answer.");
            System.out.println("##########################################################################");
            System.out.println(player.getName() + " Please select the topic for your quiz from the below options:");
            System.out.println("1.Core java programming");
            System.out.println("2.General Knowledge");
            int topic = input.nextInt();
            System.out.println("Your Time starts now "+ dateFormat.format(cal.getTime().getTime() ) );

            do {
            	Timer time = new Timer();
            	Thread t = new Thread(time);
            	
            	 if (topic == 1 || topic == 2) {
            		 t.start();
                     QuestionService service = new QuestionService(topic);
                     service.playQuiz(player);
                     
                 }
                System.out.println("Do you want to play again?Y/N : ");

                String ready = input.next();
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
