package org.sanskar;

import static org.sanskar.csvReader.readcsv;

import java.lang.reflect.Array;
import java.util.logging.Logger;

import java.io.IOException;
import java.util.*;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static List<ipl> teamlist;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String filePath = "src/main/resources/IPL_2021-data.csv";

        teamlist = readcsv(filePath);

        logger.info("Choose an option ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                String teamName = sc.next();
                Map<String, String> bowlers = allBowl(teamName);
                for (String key : bowlers.keySet()) {
                    String value = bowlers.get(key);
                    logger.info("Name: " + key + ", Wickets: " + value);
                }
                break;
            case 2:
                String teamNme = sc.next();
                try{
                    String[] highest = wicketscore(teamNme);
                    logger.info("Highest wicket taker : " + highest[0] + " Highest scorer : " + highest[1]);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            break;
            case 3:
                top3();
                break;
            default: logger.info("Choose another option");
        }


    }

    private static Map<String, String> allBowl(String teamName) {
        Map<String, String> namewickets = new HashMap<>();

        for(int i = 0; i < teamlist.size(); i++){
            if(teamlist.get(i).getTeam().equals(teamName)){
                if((Integer.parseInt(teamlist.get(i).getWickets())) >= 40){
                    if(teamlist.get(i).getRole().equals("BOWLER") || teamlist.get(i).getRole().equals("ALL ROUNDER")){
                            String name = teamlist.get(i).getName();
                            String wickets = teamlist.get(i).getWickets();
                            namewickets.put(name, wickets);
                    }
                }
            }
        }
        return namewickets;
    }

    public static String[] wicketscore(String teamName){
        String[] highfound = new String[2];
        highfound[0] = "0";
        highfound[1] = "0";
        for(int i = 0; i < teamlist.size(); i++){
            if(teamlist.get(i).getTeam().equals(teamName)){
                if(Integer.parseInt(highfound[0]) < Integer.parseInt(teamlist.get(i).getWickets())){
                    highfound[0] = teamlist.get(i).getWickets();
                }
                if(Integer.parseInt(highfound[1]) < Integer.parseInt(teamlist.get(i).getRuns())){
                    highfound[1] = teamlist.get(i).getRuns();
                }
            }
        }
        return highfound;
    }


    public static void top3() {
        Collections.sort(teamlist,new Comparator<ipl>() {
            @Override
            public int compare(ipl s1, ipl s2) {
                return s2.getRuns().compareToIgnoreCase(s1.getRuns());
            }
        });


        logger.info("top 3 run scorer are: ");
        for(int i = 0; i < 3; i++){
            logger.info(teamlist.get(i).getName() + " Runs: " +
                    teamlist.get(i).getRuns() + " " +
                    teamlist.get(i).getWickets() + " " +
                    teamlist.get(i).getTeam() + " " +
                    teamlist.get(i).getRole());
        }

        Collections.sort(teamlist,new Comparator<ipl>() {
            @Override
            public int compare(ipl s1, ipl s2) {
                return s2.getWickets().compareToIgnoreCase(s1.getWickets());
            }
        });

        logger.info("top 3 Wickets takers are: ");
        for(int i = 0; i < 3; i++){
            logger.info(teamlist.get(i).getName() + " " +
                    teamlist.get(i).getRuns() + " wickets:  " +
                    teamlist.get(i).getWickets() + " " +
                    teamlist.get(i).getTeam() + " " +
                    teamlist.get(i).getRole());
        }
    }

}