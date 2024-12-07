package bees.basketball.player.model;

import bees.basketball.gamePlayer.model.GamePlayer;
import bees.basketball.team.model.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String position;
    private int totalScore;
    private int totalGamePlayed;
    private int jerseyNumber;
    private double height;
    private int steals;
    private int losses;
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @JsonIgnore
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GamePlayer> gamePlayers = new ArrayList<>();
}
