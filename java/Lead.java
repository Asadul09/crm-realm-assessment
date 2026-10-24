
public class Lead {
    private String name;
    private String email;
    private int score;

    public Lead(String name, String email, int score) {
        this.name = name;
        this.email = email;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getScore() {
        return score;
    }

    public String getPriority() {
        if (score >= 80) {
            return "HOT";
        } else if (score >= 50) {
            return "WARM";
        } else {
            return "COLD";
        }
    }
}
