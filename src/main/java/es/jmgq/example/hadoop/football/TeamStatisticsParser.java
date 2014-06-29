package es.jmgq.example.hadoop.football;

import au.com.bytecode.opencsv.CSVParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamStatisticsParser {
    private static final int HOME_TEAM_NAME_INDEX = 2;
    private static final int HOME_GOALS_INDEX = 4;
    private static final int HOME_SHOTS_INDEX = 10;
    private static final int HOME_SHOTS_ON_TARGET_INDEX = 12;
    private static final int HOME_CORNERS_INDEX = 16;
    private static final int HOME_FOULS_INDEX = 14;
    private static final int HOME_YELLOW_CARDS_INDEX = 18;
    private static final int HOME_RED_CARDS_INDEX = 20;

    private static final int AWAY_TEAM_NAME_INDEX = 3;
    private static final int AWAY_GOALS_INDEX = 5;
    private static final int AWAY_SHOTS_INDEX = 11;
    private static final int AWAY_SHOTS_ON_TARGET_INDEX = 13;
    private static final int AWAY_CORNERS_INDEX = 17;
    private static final int AWAY_FOULS_INDEX = 15;
    private static final int AWAY_YELLOW_CARDS_INDEX = 19;
    private static final int AWAY_RED_CARDS_INDEX = 21;

    private static Logger logger = LogManager.getLogger();

    private CSVParser csvParser;

    public TeamStatisticsParser() {
        csvParser = new CSVParser();
    }

    public List<TeamStatistics> parse(String line) {
        List<TeamStatistics> statistics = new ArrayList<TeamStatistics>();
        String[] fields = {};

        try {
            fields = csvParser.parseLine(line);
        } catch (IOException e) {
            logger.error("Error parsing the line", e);
        }

        if (fields.length > 0) {
            try {
                statistics.add(parseHomeTeam(fields));
            } catch (Exception e) {
                logger.error("Error parsing the home team", e);
            }

            try {
                statistics.add(parseAwayTeam(fields));
            } catch (Exception e) {
                logger.error("Error parsing the away team", e);
            }
        }

        return statistics;
    }

    private TeamStatistics parseHomeTeam(String[] fields) {
        TeamStatistics homeStatistics = new TeamStatistics();

        homeStatistics.setTeamName(fields[HOME_TEAM_NAME_INDEX]);
        homeStatistics.setGoals(Integer.valueOf(fields[HOME_GOALS_INDEX]));
        homeStatistics.setShots(Integer.valueOf(fields[HOME_SHOTS_INDEX]));
        homeStatistics.setShotsOnTarget(Integer.valueOf(fields[HOME_SHOTS_ON_TARGET_INDEX]));
        homeStatistics.setCorners(Integer.valueOf(fields[HOME_CORNERS_INDEX]));
        homeStatistics.setFouls(Integer.valueOf(fields[HOME_FOULS_INDEX]));
        homeStatistics.setYellowCards(Integer.valueOf(fields[HOME_YELLOW_CARDS_INDEX]));
        homeStatistics.setRedCards(Integer.valueOf(fields[HOME_RED_CARDS_INDEX]));

        return homeStatistics;
    }

    private TeamStatistics parseAwayTeam(String[] fields) {
        TeamStatistics awayStatistics = new TeamStatistics();

        awayStatistics.setTeamName(fields[AWAY_TEAM_NAME_INDEX]);
        awayStatistics.setGoals(Integer.valueOf(fields[AWAY_GOALS_INDEX]));
        awayStatistics.setShots(Integer.valueOf(fields[AWAY_SHOTS_INDEX]));
        awayStatistics.setShotsOnTarget(Integer.valueOf(fields[AWAY_SHOTS_ON_TARGET_INDEX]));
        awayStatistics.setCorners(Integer.valueOf(fields[AWAY_CORNERS_INDEX]));
        awayStatistics.setFouls(Integer.valueOf(fields[AWAY_FOULS_INDEX]));
        awayStatistics.setYellowCards(Integer.valueOf(fields[AWAY_YELLOW_CARDS_INDEX]));
        awayStatistics.setRedCards(Integer.valueOf(fields[AWAY_RED_CARDS_INDEX]));

        return awayStatistics;
    }
}
