package pl.pjatk.gameplay.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.gameplay.player.model.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.health = :health" +
            " and p.nickname = :nickname")
    List<Player> getPlayerWhereHpIsFull(int health, String nickname);

    List<Player> findByHealthAndNickname(int health, String nickname);
}
