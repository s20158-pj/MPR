package pl.pjatk.gameplay.player.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.gameplay.player.model.Player;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;

@SpringBootTest
public class PlayerServiceTestIT {

    @Autowired
    private PlayerService playerService;

    @Test
    void shouldBeEmpty() {
        List<Player> all = playerService.findAll();
        assertThat(all).isEmpty();
    }

    @Test
    void shouldSaveToDb() {
        Player player = new Player("nick", 100, 10, 10, List.of());
        Player save = playerService.save(player);
        assertThat(save.getId()).isNotNull();
    }

    @Test
    void shouldThrowException() {
        Player player = new Player("nick", 100, 10, 10, List.of());
        Player save = playerService.save(player);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> playerService.findByID(10L));
    }

    @Test
    void shouldAttackDefender() {
        Player player = new Player(1L, "mario", 150, 40, 10);
        Player player2 = new Player(2L, "luigi", 100, 20, 10);

        Player save = playerService.save(player);
        Player save2 = playerService.save(player2);

        playerService.attack(save.getId(), save2.getId());

        assertThat(playerService.findByID(save2.getId()).get().getHealth()).isEqualTo(60);
    }
}
