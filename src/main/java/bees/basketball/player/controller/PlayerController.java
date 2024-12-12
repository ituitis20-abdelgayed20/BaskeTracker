package bees.basketball.player.controller;

import bees.basketball.player.PlayerService;
import bees.basketball.player.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player newPlayer) {
        Player createdPlayer = playerService.createPlayer(newPlayer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId) {
        Player player = playerService.getPlayerById(playerId);
        return ResponseEntity.status(HttpStatus.OK).body(player);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }

    @GetMapping("/teams/{teamId}")
    public ResponseEntity<List<Player>> getPlayersByTeamId(@PathVariable Long teamId) {
        List<Player> players = playerService.getPlayersByTeamId(teamId);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }


    @PutMapping("/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long playerId, @RequestBody Player updatedPlayer) {
        Player updated = playerService.updatePlayer(playerId, updatedPlayer);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> deletePlayerById(@PathVariable Long playerId) {
        playerService.deletePlayerById(playerId);
        return ResponseEntity.status(HttpStatus.OK).body("The player is deleted successfully");
    }
}
