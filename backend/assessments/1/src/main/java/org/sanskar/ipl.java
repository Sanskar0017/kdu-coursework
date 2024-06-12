package org.sanskar;

public class ipl {
    private final String name;

    public String getRuns() {
        return runs;
    }

    private final String team;
    private final String role;
    private final String runs;
    private final String wickets;


    public ipl(String name, String team, String role, String matches, String runs, String average, String sr, String wickets) {
        this.name = name;
        this.team = team;
        this.role = role;
        this.runs = runs;
        this.wickets = wickets;
    }

    public String getTeam() {
        return team;
    }

    public String getWickets() {
        return wickets;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}
