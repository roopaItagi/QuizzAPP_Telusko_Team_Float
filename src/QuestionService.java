import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[5];
    String selection[] = new String[5];

    int topicNo;

    public QuestionService()
    {
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");

    }
    public QuestionService(int topic){

        if(topic==1){
            questions[0] = new Question(1, "What is the meaning of Telusko: ", "Get to know ", "Learn", "Knowledge", "Both 1 and 2", "4");
            questions[1] = new Question(2, "When was Telusko founded", "2", "6", "4", "8", "1");
            questions[2] = new Question(3, "How many children Navin Reddy has", "Two", "one", "Three", "None", "1");
            questions[3] = new Question(4, "What is Navin Reddy's fav word", "Aliens", "friends", "Apple", "youtube", "1");
            questions[4] = new Question(5, "What is Navin Reddy's Wife's name", "Kajol", "Kiran", "Reema", "Deepika", "2");
        }
        if(topic==2){
            questions[0] = new Question(1, "What is the extension of java code files?", ".js", ".txt", ".class", ".java", "4");
            questions[1] = new Question(2, "Which one of the following is not an access modifier?", "protected", "private", "void", "public", "3");
            questions[2] = new Question(3, "What is the return type of Constructors", "int", "float", "void", "none of the above", "4");
            questions[3] = new Question(4, "Which keyword is used by the method to refer to the object that invoked it?", "import", "catch", "abstract", "this", "4");
            questions[4] = new Question(5, "Which of the following statements are incorrect?", "String is a class", "Strings in java are mutable", "Every String is an object of class String", "None of the above", "2");
        }

    }

    public void displayQuestions()
    {
        for(Question question : questions) {
            System.out.println(question.toString());
        }

    }

    public void playQuiz(Player player)
    {
        int i=0;
        int score=0;
        String answer;
        for(Question q : questions){

            System.out.println("Question " + (i+1) + " : ");
            System.out.println(q.getId()+"."+q.getQuestion());
            System.out.println("1. "+q.getOpt1());
            System.out.println("2. "+q.getOpt2());
            System.out.println("3. "+q.getOpt3());
            System.out.println("4. "+q.getOpt4());
            System.out.println(" ");
            System.out.println("Do you want to skip this question?Please enter Y/N:  ");
            Scanner sc = new Scanner(System.in);
            String skipScan= sc.next().trim();
            if(skipScan.equalsIgnoreCase("Y")){
                i++;
                continue;
            }
            System.out.println("Enter the right option:");
           Scanner AnsScanner = new Scanner(System.in);

            selection[i] = AnsScanner.nextLine().trim();
            answer=q.getAnswer();
            if(answer.equals( selection[i])){
                System.out.println("Correct Answer");
                score++;
            }
            else{
                System.out.println("Wrong answer!!!!");
                score--;
            }

            System.out.println("Your current score is : " + score+"/"+selection.length);
            i++;

        }
        if(score==selection.length){
            System.out.println();
            System.out.println("Congratulations!!!!! "+player.getName());
            System.out.println("Your Final score is : " + score+"/"+selection.length);
        }
        else {
            System.out.println();
            System.out.println(player.getName() + " Your Final score is : " + score+"/"+selection.length);
        }
    }

    /*public void printScore(){
        int score=0;
        for(String s : selection){
            System.out.println(s);
        }
        for(int i=0;i<5;i++){
            Question q = questions[i];
            String answer = q.getAnswer();
            String selAnswer = selection[i];

            if(answer.equals(selAnswer)){

                score++;
            }
            else{

                score--;
            }

            System.out.println("Your current score is : " + score);
        }
        System.out.println("Your Final score is : " + score);
    }*/

}
