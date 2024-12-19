package bees.basketball.gamePlayer.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayer, Long> {

    List<GamePlayer> findByGameId(Long gameId);

    List<GamePlayer> findByPlayerId(Long playerId);

    @Query("SELECT gp FROM GamePlayer gp WHERE gp.game.id = :gameId AND gp.player.id = :playerId")
    GamePlayer findByGameIdAndPlayerId(@Param("gameId") Long gameId, @Param("playerId") Long playerId);
}
