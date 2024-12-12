package bees.basketball.player;

import bees.basketball.player.model.Player;
import bees.basketball.player.model.PlayerRepository;
import bees.basketball.team.TeamService;
import bees.basketball.team.model.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamService teamService;

    public Player createPlayer(Player newPlayer) {
        validatePlayerNameUniqueness(newPlayer.getFullName());
        return playerRepository.save(newPlayer);
    }

    public void createPlayers(List<Player> players) {
        playerRepository.saveAll(players);
    }

    public Player getPlayerById(Long playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isPresent()) {
            return playerOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found with ID: " + playerId);
        }
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByTeamId(Long teamId) {
        // You can validate that the team exists if needed
        teamService.getTeamById(teamId); // This is assuming you have a TeamService to validate teams
        return playerRepository.findByTeamId(teamId);
    }

    public Player updatePlayer(Long playerId, Player updatedPlayer) {
        Optional<Player> existingPlayerOptional = playerRepository.findById(playerId);

        if (existingPlayerOptional.isPresent()) {
            Player existingPlayer = existingPlayerOptional.get();
            updatePlayerAttributes(updatedPlayer, existingPlayer);
            return playerRepository.save(existingPlayer);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found with ID: " + playerId);
        }
    }

    public void deletePlayerById(Long playerId) {
        if (playerRepository.existsById(playerId)) {
            playerRepository.deleteById(playerId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found with ID: " + playerId);
        }
    }

    private void updatePlayerAttributes(Player updatedPlayer, Player existingPlayer) {
        existingPlayer.setFullName(updatedPlayer.getFullName() != null ? updatedPlayer.getFullName() : existingPlayer.getFullName());
        existingPlayer.setPosition(updatedPlayer.getPosition() != null ? updatedPlayer.getPosition() : existingPlayer.getPosition());
        existingPlayer.setTotalScore(updatedPlayer.getTotalScore());
        existingPlayer.setTotalGamePlayed(updatedPlayer.getTotalGamePlayed());
        existingPlayer.setJerseyNumber(updatedPlayer.getJerseyNumber());
        existingPlayer.setHeight(updatedPlayer.getHeight());
        existingPlayer.setSteals(updatedPlayer.getSteals());
        existingPlayer.setLosses(updatedPlayer.getLosses());
        existingPlayer.setAge(updatedPlayer.getAge());
        existingPlayer.setTeam(updatedPlayer.getTeam() != null ? updatedPlayer.getTeam() : existingPlayer.getTeam());
    }


    private void validatePlayerNameUniqueness(String fullName) {
        if (playerRepository.existsByFullName(fullName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Player with the same name already exists");
        }
    }
}
