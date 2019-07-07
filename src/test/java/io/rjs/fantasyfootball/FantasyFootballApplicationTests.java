package io.rjs.fantasyfootball;

import io.rjs.fantasyfootball.domain.FantasyTeam;
import io.rjs.fantasyfootball.domain.Player;
import io.rjs.fantasyfootball.domain.Position;
import io.rjs.fantasyfootball.domain.Team;
import io.rjs.fantasyfootball.repository.FantasyTeamRepository;
import io.rjs.fantasyfootball.repository.PlayerRepository;
import io.rjs.fantasyfootball.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FantasyFootballApplicationTests {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private FantasyTeamRepository fantasyTeamRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createTeam() {
        Team team = new Team();
        team.setName("NE");
        team.setLogoUrl("http://logo.png");
        team.setByeWeek(7);

        Team newTeam = teamRepository.save(team);
        assertNotNull(newTeam.getId());
    }

    @Test
    public void createFantasyTeam() {
        FantasyTeam team = new FantasyTeam();
        team.setName("Test Team 1");
        team.setOwner("Owner 1");
        team.setPick(5);

        FantasyTeam newTeam = fantasyTeamRepository.save(team);
        assertNotNull(newTeam.getId());
    }

    @Test
    public void createPlayer() {
        Team team = new Team();
        team.setName("CLE");
        team.setLogoUrl("http://logo.png");
        team.setByeWeek(7);

        team = teamRepository.save(team);

        Player player = new Player();
        player.setName("Baker Mayfield");
        player.setPosition(Position.QB);
        player.setIrlTeam(team);
        player = playerRepository.save(player);
        assertNotNull(player.getId());
        assertEquals(team.getId(), player.getIrlTeam().getId());
    }

    public void draftPlayer() {
        FantasyTeam fantasyTeam = new FantasyTeam();
        fantasyTeam.setName("Test Team 2");
        fantasyTeam.setOwner("Owner 2");
        fantasyTeam.setPick(5);

        fantasyTeam = fantasyTeamRepository.save(fantasyTeam);

        Team team = new Team();
        team.setName("NYG");
        team.setLogoUrl("http://logo.png");
        team.setByeWeek(7);

        team = teamRepository.save(team);

        Player player = new Player();
        player.setName("Saquon Barkley");
        player.setPosition(Position.RB);
        player.setIrlTeam(team);
        player.setFantasyTeam(fantasyTeam);
        player = playerRepository.save(player);

        fantasyTeam = fantasyTeamRepository.findById(fantasyTeam.getId()).get();
        assertEquals(1, fantasyTeam.getRoster().size());
    }
}
