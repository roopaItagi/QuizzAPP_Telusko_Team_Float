public class QuestionService {
    Question[] questions = new Question[5];
    String[] selection = new String[5];
    int i = 0;
    public QuestionService() {
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");

    }

    /* Parameterised Constructor for creating object of type QuestionService class*/
    public QuestionService(String topic) {

        if ("1".equalsIgnoreCase(topic)) {
            questions[0] = new Question(1, "What is the extension of java code files?", ".js", ".txt", ".class", ".java", "4");
            questions[1] = new Question(2, "Which one of the following is not an access modifier?", "protected", "private", "void", "public", "3");
            questions[2] = new Question(3, "What is the return type of Constructors?", "int", "float", "void", "none of the above", "4");
            questions[3] = new Question(4, "Which keyword is used by the method to refer to the object that invoked it?", "import", "catch", "abstract", "this", "4");
            questions[4] = new Question(5, "Which of the following statements are incorrect?", "String is a class", "Strings in java are mutable", "Every String is an object of class String", "None of the above", "2");
        }

        if ("2".equalsIgnoreCase(topic)) {
            questions[0] = new Question(1, "What company was originally called Cadabra? ", "Amazon ", "Microsoft", "Oracle", "None of the above", "1");
            questions[1] = new Question(2, "When was Telusko founded?", "2010", "2014", "2020", "2019", "2");
            questions[2] = new Question(3, "What is a group of crows called?", "A murder", "A parliament", "A crew", "None of these", "1");
            questions[3] = new Question(4, "What is Navin Reddy's fav word?", "Aliens", "friends", "Apple", "youtube", "1");
            questions[4] = new Question(5, "What is the only continent with land in all four hemispheres?", "Asia", "Africa", "Europe", "South America", "2");
        }
    }
}