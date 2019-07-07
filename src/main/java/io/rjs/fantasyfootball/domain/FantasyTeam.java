package io.rjs.fantasyfootball.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fantasy_team")
@Getter
@Setter
@NoArgsConstructor
public class FantasyTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", nullable = false, unique = true, length = 25)
    private String name;
    @Column(name = "owner", nullable = false, length = 25)
    private String owner;
    @Column(name = "pick")
    private Integer pick;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fantasyTeam")
    private Set<Player> roster = new LinkedHashSet<>();
}
