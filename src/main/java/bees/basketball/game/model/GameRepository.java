package bees.basketball.game.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByTeam1IdOrTeam2Id(Long team1Id, Long team2Id);

    @Query("SELECT g FROM Game g WHERE g.team1.id = :teamId OR g.team2.id = :teamId")
    List<Game> findGamesByTeamId(@Param("teamId") Long teamId);
}
