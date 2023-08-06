public class Player {
     private String name;
    private int score;
    private int noOfTrials;

    public Player(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getNoOfTrials() {
        return noOfTrials;
    }
    public void setNoOfTrials(int noOfTrials) {
        this.noOfTrials = noOfTrials;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
