package nam.tran.architechture.application.model;

public class SoccerSeasonModel {

    public int id;
    public String caption;
    public String league;
    public String year;
    public int currentMatchday;
    public int numberOfMatchdays;
    public int numberOfTeams;
    public int numberOfGames;
    public String lastUpdated;

    public String getNumberOfTeams() {
        return String.valueOf(numberOfTeams);
    }
}
