package io.rjs.fantasyfootball.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "player")
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "position", nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne(optional = false)
    @JoinColumn(name = "irl_team_id", nullable = false)
    private Team irlTeam;

    @ManyToOne(optional = true)
    @JoinColumn(name = "fantasy_team_id")
    private FantasyTeam fantasyTeam;
}
