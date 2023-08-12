
public class Timer implements Runnable {

	@Override
	public void run() {
		long endTime = 0;
		QuestionService service = null;
		endTime = System.currentTimeMillis() + 30000;

		while (true) {

			if (System.currentTimeMillis() > endTime) {
				System.out.println("Timeout, See you again");
				System.exit(0);
				
			}
		}

	}

}


