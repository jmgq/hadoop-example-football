package es.jmgq.example.hadoop.football;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class TeamStatisticsTest {
    private TeamStatistics sut;

    @DataProvider
    private static final Object[][] nameProvider() {
        return new String[][] {{"F. C. Barcelona"}, {"Celta de Vigo"}, {"Malaga"}};
    }

    @DataProvider
    private static final Object[][] nonNegativeIntegerProvider() {
        return new Integer[][] {{0}, {1}, {2}, {14}};
    }

    @DataProvider
    private static final Object[][] invalidNonNegativeIntegerProvider() {
        return new Integer[][] {{null}, {-1}, {-6}};
    }

    @BeforeMethod
    public void setUp() {
        sut = new TeamStatistics();
    }

    @Test(dataProvider = "nameProvider")
    public void shouldSetTeamName(String name) {
        sut.setTeamName(name);

        assertEquals(sut.getTeamName(), name);
    }

    @Test(dataProvider = "nonNegativeIntegerProvider")
    public void shouldSetGoals(Integer goals) {
        sut.setGoals(goals);

        assertEquals(sut.getGoals(), goals);
    }

    @Test(
        dataProvider = "invalidNonNegativeIntegerProvider",
        expectedExceptions = {IllegalArgumentException.class}
    )
    public void shouldNotSetInvalidGoalsNumber(Integer goals) {
        sut.setGoals(goals);
    }

    @Test(dataProvider = "nonNegativeIntegerProvider")
    public void shouldSetShots(Integer shots) {
        sut.setShots(shots);

        assertEquals(sut.getShots(), shots);
    }

    @Test(
            dataProvider = "invalidNonNegativeIntegerProvider",
            expectedExceptions = {IllegalArgumentException.class}
    )
    public void shouldNotSetInvalidShotsNumber(Integer shots) {
        sut.setShots(shots);
    }

    @Test(dataProvider = "nonNegativeIntegerProvider")
    public void shouldSetShotsOnTarget(Integer shotsOnTarget) {
        sut.setShotsOnTarget(shotsOnTarget);

        assertEquals(sut.getShotsOnTarget(), shotsOnTarget);
    }

    @Test(
            dataProvider = "invalidNonNegativeIntegerProvider",
            expectedExceptions = {IllegalArgumentException.class}
    )
    public void shouldNotSetInvalidShotsOnTargetNumber(Integer shotsOnTarget) {
        sut.setShotsOnTarget(shotsOnTarget);
    }

    @Test(dataProvider = "nonNegativeIntegerProvider")
    public void shouldSetCorners(Integer corners) {
        sut.setCorners(corners);

        assertEquals(sut.getCorners(), corners);
    }

    @Test(
            dataProvider = "invalidNonNegativeIntegerProvider",
            expectedExceptions = {IllegalArgumentException.class}
    )
    public void shouldNotSetInvalidCornersNumber(Integer corners) {
        sut.setCorners(corners);
    }

    @Test(dataProvider = "nonNegativeIntegerProvider")
    public void shouldSetFouls(Integer fouls) {
        sut.setFouls(fouls);

        assertEquals(sut.getFouls(), fouls);
    }

    @Test(
            dataProvider = "invalidNonNegativeIntegerProvider",
            expectedExceptions = {IllegalArgumentException.class}
    )
    public void shouldNotSetInvalidFoulsNumber(Integer fouls) {
        sut.setFouls(fouls);
    }

    @Test(dataProvider = "nonNegativeIntegerProvider")
    public void shouldSetYellowCards(Integer yellowCards) {
        sut.setYellowCards(yellowCards);

        assertEquals(sut.getYellowCards(), yellowCards);
    }

    @Test(
            dataProvider = "invalidNonNegativeIntegerProvider",
            expectedExceptions = {IllegalArgumentException.class}
    )
    public void shouldNotSetInvalidYellowCardsNumber(Integer yellowCards) {
        sut.setYellowCards(yellowCards);
    }

    @Test(dataProvider = "nonNegativeIntegerProvider")
    public void shouldSetRedCards(Integer redCards) {
        sut.setRedCards(redCards);

        assertEquals(sut.getRedCards(), redCards);
    }

    @Test(
            dataProvider = "invalidNonNegativeIntegerProvider",
            expectedExceptions = {IllegalArgumentException.class}
    )
    public void shouldNotSetInvalidRedCardsNumber(Integer redCards) {
        sut.setRedCards(redCards);
    }
}
