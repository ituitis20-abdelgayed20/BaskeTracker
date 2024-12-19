package bees.basketball.gamePlayer.controller;

import bees.basketball.gamePlayer.GamePlayerService;
import bees.basketball.gamePlayer.model.GamePlayer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game_players")
@RequiredArgsConstructor
public class GamePlayerController {

    private final GamePlayerService gamePlayerService;

    @PostMapping("/games/{gameId}/players/{playerId}")
    public ResponseEntity<GamePlayer> createGamePlayer(@PathVariable Long gameId,
                                                       @PathVariable Long playerId,
                                                       @RequestBody GamePlayer newGamePlayer) {
        GamePlayer createdGamePlayer = gamePlayerService.createGamePlayer(gameId, playerId, newGamePlayer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGamePlayer);
    }

    @GetMapping("/{gamePlayerId}")
    public ResponseEntity<GamePlayer> getGamePlayerById(@PathVariable Long gamePlayerId) {
        GamePlayer gamePlayer = gamePlayerService.getGamePlayerById(gamePlayerId);
        return ResponseEntity.status(HttpStatus.OK).body(gamePlayer);
    }

    @GetMapping
    public ResponseEntity<List<GamePlayer>> getAllGamePlayers() {
        List<GamePlayer> gamePlayers = gamePlayerService.getAllGamePlayers();
        return ResponseEntity.status(HttpStatus.OK).body(gamePlayers);
    }

    @PutMapping("/{gamePlayerId}")
    public ResponseEntity<GamePlayer> updateGamePlayer(@PathVariable Long gamePlayerId,
                                                       @RequestBody GamePlayer updatedGamePlayer) {
        GamePlayer updated = gamePlayerService.updateGamePlayer(gamePlayerId, updatedGamePlayer);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/{gamePlayerId}")
    public ResponseEntity<String> deleteGamePlayerById(@PathVariable Long gamePlayerId) {
        gamePlayerService.deleteGamePlayerById(gamePlayerId);
        return ResponseEntity.status(HttpStatus.OK).body("The game player is deleted successfully");
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<List<GamePlayer>> getGamePlayersByGameId(@PathVariable Long gameId) {
        List<GamePlayer> gamePlayers = gamePlayerService.getGamePlayersByGameId(gameId);
        return ResponseEntity.status(HttpStatus.OK).body(gamePlayers);
    }

    @GetMapping("/players/{playerId}")
    public ResponseEntity<List<GamePlayer>> getGamePlayersByPlayerId(@PathVariable Long playerId) {
        List<GamePlayer> gamePlayers = gamePlayerService.getGamePlayersByPlayerId(playerId);
        return ResponseEntity.status(HttpStatus.OK).body(gamePlayers);
    }
}
