
public class Timer implements Runnable {
	QuestionService q = new QuestionService();
	@Override
	public void run() {

		while (true) {

			q.timeOut();
		}

	}
	
}


