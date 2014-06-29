package es.jmgq.example.hadoop.football;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Test
public class TeamStatisticsParserTest {
    private TeamStatisticsParser sut;

    @BeforeMethod
    public void setUp() {
        sut = new TeamStatisticsParser();
    }

    public void shouldParseHomeTeam() {
        String line = ",,Espanol,,1,,,,,,10,,2,,18,,1,,3,,0";

        List<TeamStatistics> statistics = sut.parse(line);

        assertEquals(statistics.size(), 1);

        TeamStatistics homeTeamStatistics = statistics.get(0);

        assertEquals(homeTeamStatistics.getTeamName(), "Espanol");
        assertEquals(homeTeamStatistics.getGoals().intValue(), 1);
        assertEquals(homeTeamStatistics.getShots().intValue(), 10);
        assertEquals(homeTeamStatistics.getShotsOnTarget().intValue(), 2);
        assertEquals(homeTeamStatistics.getFouls().intValue(), 18);
        assertEquals(homeTeamStatistics.getCorners().intValue(), 1);
        assertEquals(homeTeamStatistics.getYellowCards().intValue(), 3);
        assertEquals(homeTeamStatistics.getRedCards().intValue(), 0);
    }

    public void shouldParseAwayTeam() {
        String line = ",,,Valladolid,,0,,,,,,11,,1,,17,,9,,5,,0";

        List<TeamStatistics> statistics = sut.parse(line);

        assertEquals(statistics.size(), 1);

        TeamStatistics awayTeamStatistics = statistics.get(0);

        assertEquals(awayTeamStatistics.getTeamName(), "Valladolid");
        assertEquals(awayTeamStatistics.getGoals().intValue(), 0);
        assertEquals(awayTeamStatistics.getShots().intValue(), 11);
        assertEquals(awayTeamStatistics.getShotsOnTarget().intValue(), 1);
        assertEquals(awayTeamStatistics.getFouls().intValue(), 17);
        assertEquals(awayTeamStatistics.getCorners().intValue(), 9);
        assertEquals(awayTeamStatistics.getYellowCards().intValue(), 5);
        assertEquals(awayTeamStatistics.getRedCards().intValue(), 0);
    }

    public void shouldParseBothTeams() {
        String line = "SP1,30/08/08,Espanol,Valladolid,1,0,H,0,0,D,10,11,2,1,18,17,1,9,3,5,0,0,2,3.3,3.8,1.8,3.25,4.1,2,3.2,3.75,1.75,3.2,4.3,1.8,3.2,4,1.85,3.2,4,1.83,3.2,3.75,2,3.2,4,1.9,3.25,3.5,1.8,3.25,4.33,37,2.09,1.9,3.4,3.25,4.5,3.99,29,2.12,2.04,1.83,1.72,20,0,1.46,1.4,3,2.77";

        List<TeamStatistics> statistics = sut.parse(line);

        assertEquals(statistics.size(), 2);
    }

    public void shouldParseEmptyLine() {
        String emptyLine = "";

        List<TeamStatistics> statistics = sut.parse(emptyLine);

        assertEquals(statistics.size(), 0);
    }

    public void shouldParseInvalidLine() {
        String invalidLine = "This,is,invalid";

        List<TeamStatistics> statistics = sut.parse(invalidLine);

        assertEquals(statistics.size(), 0);
    }
}
