package bees.basketball.game.controller;

import bees.basketball.game.GameService;
import bees.basketball.game.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/teams/{team1Id}/teams/{team2Id}")
    public ResponseEntity<Game> createGame(@PathVariable Long team1Id,
                                           @PathVariable Long team2Id,
                                           @RequestBody Game newGame) {
        Game createdGame = gameService.createGame(team1Id, team2Id, newGame);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable Long gameId) {
        Game game = gameService.getGameById(gameId);
        return ResponseEntity.status(HttpStatus.OK).body(game);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<Game> updateGame(@PathVariable Long gameId,
                                           @RequestBody Game updatedGame) {
        Game updated = gameService.updateGame(gameId, updatedGame);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<String> deleteGameById(@PathVariable Long gameId) {
        gameService.deleteGameById(gameId);
        return ResponseEntity.status(HttpStatus.OK).body("The game is deleted successfully");
    }

    @GetMapping(params = "teamId")
    public ResponseEntity<List<Game>> getGamesByTeamId(@RequestParam(required = false) Long teamId) {
        List<Game> games = gameService.getGamesByTeamId(teamId);
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

}
