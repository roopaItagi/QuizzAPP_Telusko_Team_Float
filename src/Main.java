import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        PlayQuiz play = new PlayQuiz(15, TimeUnit.SECONDS);
        play.startQuiz();
    }
}
