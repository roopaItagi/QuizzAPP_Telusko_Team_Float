import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.*;
public class PlayQuiz  extends QuestionService {
    private static int timeout=5;
    private static TimeUnit unit = null;

    public PlayQuiz(int timeout, TimeUnit unit) {

        this.timeout = timeout;
        this.unit = unit;
    }

    public void startQuiz() {
        boolean playAgain;
        displayWelcome();
        do {
            System.out.println("Choose your option: ");
            System.out.println("Trainer --> Enter 1.");
            System.out.println("Player -->  Enter 2.");
            Scanner input = new Scanner(System.in);
            String role ;
            role = input.next();
            //todo: validate role input
            if ("1".equalsIgnoreCase(role)) {
                //todo : implement code to create the quiz and start the quiz by trainer.

                System.out.println(" //todo :still working on implementing code to create the quiz and start the quiz by trainer. ");
                System.out.println("Please start again");


            } else if ("2".equalsIgnoreCase(role)) {
                displayRules();
                System.out.println("Please enter your name: ");
                String name = input.next();
                displayTopic();
                String topic = input.next();
                // System.out.println("Your Time starts now " + dateFormat.format(cal.getTime().getTime()));

                //Create player object to store name and score
                Player player = new Player(name, 0);

                //create QuestionService object to create question list based on the topic selected
                QuestionService questionList;
                if("1".equalsIgnoreCase(topic) ||"2".equalsIgnoreCase(topic) ) {
                    // create a question list from parameterised  constructor if input is 1 or 2
                    questionList = new QuestionService(topic);
                }else{
                    // create a question list from default constructor if input is other than 1 and 2
                    questionList = new QuestionService();
                }

                //Iterate through each question
                for (Question q : questionList.questions) {
                    try {
                        System.out.println("Question " + q.getId() + " : ");
                        System.out.println(q.getId() + "." + q.getQuestion());
                        System.out.println("1. " + q.getOpt1());
                        System.out.println("2. " + q.getOpt2());
                        System.out.println("3. " + q.getOpt3());
                        System.out.println("4. " + q.getOpt4());
                        System.out.println("Enter the right option: or type s to skip this question");

                        String skipScan = readDataFromConsole();
//                        Scanner input2 = new Scanner(System.in);
//                        String skipScan = input2.next();
                        if ("s".equalsIgnoreCase(skipScan)) {
                            //i++;
                            System.out.println("skipping question");
                            // Thread.currentThread().interrupt();
                            System.out.println("------------------------------------------------------");
                        } else if(null!=skipScan && !skipScan.isEmpty()) {
                            if (checkforInteger(skipScan)) {
                                selection[i] = skipScan;
                                String answer = q.getAnswer();
                                if (answer.equals(selection[i])) {
                                    System.out.println("Correct Answer");
                                    player.score++;
                                } else {
                                    System.out.println("Wrong answer!!!!");
                                    System.out.println("The correct option is : " + answer);
                                    player.score--;
                                }
                                System.out.println("Your current score is : " + player.score + "/" + selection.length);
                                System.out.println("------------------------------------------------------");
                            }else{
                                System.out.println("Invalid Input!!!!");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Your final score is : " + player.score + "/" + selection.length);
                System.out.println("------------------------------------------------------");
            }
            else{
                System.out.println("Invalid Input for role!!!!");
            }

            System.out.println("Do you want to play again?Y/N : ");
            String ready = input.next();
            if (ready != null && ready.equalsIgnoreCase("Y")) {
                playAgain = true;
            } else {
                playAgain = false;
                break;

            }
        } while (playAgain);



    }

    public static void displayWelcome() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        System.out.println("###############################################################");
        System.out.println("                       Welcome to QuizApp                      ");
        System.out.println("###############################################################");

    }

    public static void displayRules() {
        System.out.println("##########################################################################");
        System.out.println("Please read the Quiz rules:  ");
        System.out.println("**There are total 5 questions and Time limit for each question is 15 seconds.");
        System.out.println("**You have the option to skip the question if you do not want to answer.");
        System.out.println("**1 point will be deducted from your score for each wrong answer.");
        System.out.println("##########################################################################");
    }

    public static void displayTopic() {
        System.out.println(" Please select the topic for your quiz from the below options:");
        System.out.println("1.Core java programming");
        System.out.println("2.General Knowledge");
    }

    public static String readDataFromConsole() throws InterruptedException{

        ExecutorService ex = Executors.newSingleThreadExecutor();//Returns: the newly created single-threaded Executor
        String input1 = null;

        try {
            // start working

            //System.out.println(String.valueOf(i + 1) + ". loop");
            Future<String> result = ex.submit(
                    new ConsoleInputReadTask());
            try {
                input1 = result.get(timeout, unit);

            } catch (ExecutionException e) {
                e.getCause().printStackTrace();
            } catch (TimeoutException e) {
                //System.out.println("Cancelling reading task");
                result.cancel(true);
                System.out.println("\nTimeout!");
                System.out.println("------------------------------------------------------");
            }
        }
        finally {
            ex.shutdownNow();
        }

        return input1;
    }
    public boolean checkforInteger(String skipScan){
        boolean result=false;
        if(skipScan.equalsIgnoreCase("1")||
                skipScan.equalsIgnoreCase("2")||
                skipScan.equalsIgnoreCase("3")||
                skipScan.equalsIgnoreCase("4")){
            result=true;
        }
        return result;
    }




}








