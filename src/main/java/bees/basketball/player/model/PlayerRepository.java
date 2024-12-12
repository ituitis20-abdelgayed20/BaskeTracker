package bees.basketball.player.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    boolean existsByFullName(String fullName);
    List<Player> findByTeamId(Long teamId);
}

