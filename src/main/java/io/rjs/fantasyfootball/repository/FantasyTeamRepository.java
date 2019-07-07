package io.rjs.fantasyfootball.repository;

import io.rjs.fantasyfootball.domain.FantasyTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FantasyTeamRepository extends JpaRepository<FantasyTeam, Integer> {
}
