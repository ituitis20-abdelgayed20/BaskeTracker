package bees.basketball.gamePlayer.model;

import bees.basketball.game.model.Game;
import bees.basketball.player.model.Player;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    private int score;
    private int assists;
    private int rebounds;
    private int minutesPlayed;
}
