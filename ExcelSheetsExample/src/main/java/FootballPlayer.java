

public class FootballPlayer {
  // Attributes
  private String name;
  private Integer age;
  private Integer goals;
  private Integer games;
  private String team;
  private String  league;

  // Constructor
  public FootballPlayer(String name, Integer age, Integer goals, Integer games, String team,
      String league) {
    this.name = name;
    this.age = age;
    this.goals = goals;
    this.games = games;
    this.team = team;
    this.league = league;
  }

  // Getters

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Integer getGoals() {
    return goals;
  }

  public Integer getGames() {
    return games;
  }

  public String getTeam() {
    return team;
  }

  public String getLeague() {
    return league;
  }
}
