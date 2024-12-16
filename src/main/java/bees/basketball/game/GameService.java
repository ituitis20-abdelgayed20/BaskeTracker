package bees.basketball.game;

import bees.basketball.game.model.Game;
import bees.basketball.game.model.GameRepository;
import bees.basketball.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GameService {

    private final GameRepository gameRepository;
    private final TeamService teamService;

    public Game createGame(Long team1Id, Long team2Id, Game newGame) {
        newGame.setTeam1(teamService.getTeamById(team1Id));
        newGame.setTeam2(teamService.getTeamById(team2Id));
        return gameRepository.save(newGame);
    }

    public Game getGameById(Long gameId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if (gameOptional.isPresent()) {
            return gameOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found with ID: " + gameId);
        }
    }

    public List<Game> getGamesByTeamId(Long teamId) {
        teamService.getTeamById(teamId);
        return gameRepository.findGamesByTeamId(teamId);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game updateGame(Long gameId, Game updatedGame) {
        Optional<Game> existingGameOptional = gameRepository.findById(gameId);

        if (existingGameOptional.isPresent()) {
            Game existingGame = existingGameOptional.get();
            updateGameAttributes(updatedGame, existingGame);
            return gameRepository.save(existingGame);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found with ID: " + gameId);
        }
    }

    private void updateGameAttributes(Game updatedGame, Game existingGame) {
        existingGame.setDatePlayed(updatedGame.getDatePlayed() != null ? updatedGame.getDatePlayed() : existingGame.getDatePlayed());
        existingGame.setTeam1(updatedGame.getTeam1() != null ? updatedGame.getTeam1() : existingGame.getTeam1());
        existingGame.setTeam2(updatedGame.getTeam2() != null ? updatedGame.getTeam2() : existingGame.getTeam2());
        existingGame.setTeam1Score(updatedGame.getTeam1Score());
        existingGame.setTeam2Score(updatedGame.getTeam2Score());
    }

    public void deleteGameById(Long gameId) {
        if (gameRepository.existsById(gameId)) {
            gameRepository.deleteById(gameId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found with ID: " + gameId);
        }
    }
}
