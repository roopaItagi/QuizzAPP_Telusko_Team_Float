import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        PlayQuiz play = new PlayQuiz(10, TimeUnit.SECONDS);
        play.startQuiz();

    }
}