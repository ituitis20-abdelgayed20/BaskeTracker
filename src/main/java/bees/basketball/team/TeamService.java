package bees.basketball.team;

import bees.basketball.team.model.Team;
import bees.basketball.team.model.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public Team createTeam(Team newTeam) {
        validateTeamNameUniqueness(newTeam.getName());
        newTeam.setWins(0);
        newTeam.setLosses(0);
        newTeam.setTotalGamePlayed(0);
        newTeam.setTotalScore(0);
        return teamRepository.save(newTeam);
    }

    public void createTeams(List<Team> teams) {
        teamRepository.saveAll(teams);
    }



    public Team getTeamById(Long teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isPresent()) {
            return teamOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found with ID: " + teamId);
        }
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void deleteTeamById(Long teamId) {
        if (teamRepository.existsById(teamId)) {
            teamRepository.deleteById(teamId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found with ID: " + teamId);
        }
    }

    private void validateTeamNameUniqueness(String name) {
        if (teamRepository.existsByName(name)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Team with the same name already exists");
        }
    }
}