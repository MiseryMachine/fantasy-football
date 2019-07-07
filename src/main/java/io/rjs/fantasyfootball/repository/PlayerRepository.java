package io.rjs.fantasyfootball.repository;

import io.rjs.fantasyfootball.domain.Player;
import io.rjs.fantasyfootball.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByIrlTeam_Id(Integer irlTeamId);
    List<Player> findByPosition(Position position);
}
