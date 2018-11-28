package nl.hva.ict.ss;

/**
 * Player keeps track of the name and the highscore for a player.
 * Once created the name can't be changed. The best score for this player
 * can be changed during the lifetime of an instance.
 */
public class Player implements Comparable<Player> {
    private String firstName;
    private String lastName;
    private long highScore;

    public Player(String firstName, String lastName, long highScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.highScore = highScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getHighScore() {
        return highScore;
    }

    public void setHighScore(long highScore) {
        this.highScore = highScore;
    }

    @Override
    public int compareTo(Player other) {
        
        if (this.getHighScore() == other.getHighScore()) {
            int result = String.CASE_INSENSITIVE_ORDER.compare(this.getLastName(), other.getLastName());
            if (result == 0) {
                result = this.getFirstName().compareTo(other.getFirstName());
            }
            return result;
        }

        if (this.getHighScore() > other.getHighScore()) {
            return 1;
        } else if(this.getHighScore() < other.getHighScore()) {
            return -1;
        }
        return 0;
    }
}
