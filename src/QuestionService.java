import java.util.Scanner;
public class QuestionService {

    Question[] questions = new Question[5];
    String []selection = new String[5];
    private int score=0;
    long endTime = System.currentTimeMillis() + 30000;


    public int getScore() {
		return score;
	}
	public QuestionService()
    {
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");

    }
    /* Parameterised Constructor for creating object of type QuestionService class*/
    public QuestionService(int topic){
        if(topic==1){
            questions[0] = new Question(1, "What is the extension of java code files?", ".js", ".txt", ".class", ".java", "4");
            questions[1] = new Question(2, "Which one of the following is not an access modifier?", "protected", "private", "void", "public", "3");
            questions[2] = new Question(3, "What is the return type of Constructors?", "int", "float", "void", "none of the above", "4");
            questions[3] = new Question(4, "Which keyword is used by the method to refer to the object that invoked it?", "import", "catch", "abstract", "this", "4");
            questions[4] = new Question(5, "Which of the following statements are incorrect?", "String is a class", "Strings in java are mutable", "Every String is an object of class String", "None of the above", "2");
        }

        if(topic==2){
            questions[0] = new Question(1, "What company was originally called Cadabra? ", "Amazon ", "Microsoft", "Oracle", "None of the above", "1");
            questions[1] = new Question(2, "When was Telusko founded?", "2010", "2014", "2020", "2019", "2");
            questions[2] = new Question(3, "What is a group of crows called?", "A murder", "A parliament", "A crew", "None of these", "1");
            questions[3] = new Question(4, "What is Navin Reddy's fav word?", "Aliens", "friends", "Apple", "youtube", "1");
            questions[4] = new Question(5, "What is the only continent with land in all four hemispheres?", "Asia", "Africa", "Europe", "South America", "2");
        }


    }
    /* Displays question for the player and reads the input and calculates the score */

    public void playQuiz(Player player)
    {
   
        
        String answer;
		for (int i=0;i<questions.length;i++) {

			System.out.println("Question " + (i + 1) + " : ");
			Question q = questions[i];
			System.out.println(q.getId() + "." + q.getQuestion());
			System.out.println("1. " + q.getOpt1());
			System.out.println("2. " + q.getOpt2());
			System.out.println("3. " + q.getOpt3());
			System.out.println("4. " + q.getOpt4());

			System.out.println("Do you want to skip this question?Please enter Y/N:  ");
			System.out.println(" ");
			Scanner input = new Scanner(System.in);
			String skipScan = input.next();

			if (skipScan.equalsIgnoreCase("Y")) {
	
				System.out.println("------------------------------------------------------");
				continue;
			} else if (skipScan.equalsIgnoreCase("N")) {
				System.out.println("Enter the right option:");
				selection[i] = input.next();

				answer = q.getAnswer();
				if (answer.equals(selection[i])) {
					System.out.println("Correct Answer");
					score++;
				} else {
					System.out.println("Wrong answer!!!!");
					System.out.println("The correct option is : " + answer);

					score--;
				}

				System.out.println("Your current score is : " + score + "/" + selection.length);
				System.out.println("------------------------------------------------------");

			} else {
				System.out.println("Invalid option:");
				i--;
			}

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
    public void timeOut() {

		try {
			if (System.currentTimeMillis() > endTime) {
				System.out.println("Timeout, Your Final score is : " + score+"/"+selection.length);
				System.out.println("See you again");
				System.exit(0);

			}
		}
		catch(Exception e) {
			System.out.println("some issues with timout");
		}
	
		
	}


}
