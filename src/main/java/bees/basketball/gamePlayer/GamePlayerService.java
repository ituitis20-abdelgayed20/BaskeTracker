package bees.basketball.gamePlayer;

import bees.basketball.game.GameService;
import bees.basketball.gamePlayer.model.GamePlayer;
import bees.basketball.gamePlayer.model.GamePlayerRepository;
import bees.basketball.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GamePlayerService {

    private final GamePlayerRepository gamePlayerRepository;
    private final GameService gameService;
    private final PlayerService playerService;

    public GamePlayer createGamePlayer(Long gameId, Long playerId, GamePlayer newGamePlayer) {
        newGamePlayer.setGame(gameService.getGameById(gameId));
        newGamePlayer.setPlayer(playerService.getPlayerById(playerId));
        return gamePlayerRepository.save(newGamePlayer);
    }

    public GamePlayer getGamePlayerById(Long gamePlayerId) {
        Optional<GamePlayer> gamePlayerOptional = gamePlayerRepository.findById(gamePlayerId);
        if (gamePlayerOptional.isPresent()) {
            return gamePlayerOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "GamePlayer not found with ID: " + gamePlayerId);
        }
    }

    public List<GamePlayer> getGamePlayersByGameId(Long gameId) {
        gameService.getGameById(gameId);
        return gamePlayerRepository.findByGameId(gameId);
    }

    public List<GamePlayer> getGamePlayersByPlayerId(Long playerId) {
        playerService.getPlayerById(playerId);
        return gamePlayerRepository.findByPlayerId(playerId);
    }

    public List<GamePlayer> getAllGamePlayers() {
        return gamePlayerRepository.findAll();
    }

    public GamePlayer updateGamePlayer(Long gamePlayerId, GamePlayer updatedGamePlayer) {
        Optional<GamePlayer> existingGamePlayerOptional = gamePlayerRepository.findById(gamePlayerId);

        if (existingGamePlayerOptional.isPresent()) {
            GamePlayer existingGamePlayer = existingGamePlayerOptional.get();
            updateGamePlayerAttributes(updatedGamePlayer, existingGamePlayer);
            return gamePlayerRepository.save(existingGamePlayer);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "GamePlayer not found with ID: " + gamePlayerId);
        }
    }

    private void updateGamePlayerAttributes(GamePlayer updatedGamePlayer, GamePlayer existingGamePlayer) {
        existingGamePlayer.setScore(updatedGamePlayer.getScore());
        existingGamePlayer.setAssists(updatedGamePlayer.getAssists());
        existingGamePlayer.setRebounds(updatedGamePlayer.getRebounds());
        existingGamePlayer.setMinutesPlayed(updatedGamePlayer.getMinutesPlayed());
    }

    public void deleteGamePlayerById(Long gamePlayerId) {
        if (gamePlayerRepository.existsById(gamePlayerId)) {
            gamePlayerRepository.deleteById(gamePlayerId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "GamePlayer not found with ID: " + gamePlayerId);
        }
    }
}
