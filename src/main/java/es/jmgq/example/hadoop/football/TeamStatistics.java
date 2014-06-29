package es.jmgq.example.hadoop.football;

public class TeamStatistics {
    private String teamName;
    private Integer goals;
    private Integer shots;
    private Integer shotsOnTarget;
    private Integer corners;
    private Integer fouls;
    private Integer yellowCards;
    private Integer redCards;

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setGoals(Integer goals) {
        checkNonNegativeInteger(goals);

        this.goals = goals;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setShots(Integer shots) {
        checkNonNegativeInteger(shots);

        this.shots = shots;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShotsOnTarget(Integer shotsOnTarget) {
        checkNonNegativeInteger(shotsOnTarget);

        this.shotsOnTarget = shotsOnTarget;
    }

    public Integer getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setCorners(Integer corners) {
        checkNonNegativeInteger(corners);

        this.corners = corners;
    }

    public Integer getCorners() {
        return corners;
    }

    public void setFouls(Integer fouls) {
        checkNonNegativeInteger(fouls);

        this.fouls = fouls;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setYellowCards(Integer yellowCards) {
        checkNonNegativeInteger(yellowCards);

        this.yellowCards = yellowCards;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setRedCards(Integer redCards) {
        checkNonNegativeInteger(redCards);

        this.redCards = redCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    private void checkNonNegativeInteger(Integer value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Invalid value: " + value);
        }
    }
}
