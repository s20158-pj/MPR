package pl.pjatk.gameplay.player.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

import java.util.Optional;

@Service
public class DamageService {

    private PlayerService playerService;

    public DamageService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Player damage(Long attackerId, Long defenderId) {
        Optional<Player> optionalAttacker = playerService.findByID(attackerId);
        Optional<Player> optionalDefender = playerService.findByID(defenderId);

        if (optionalAttacker.isPresent() && optionalDefender.isPresent()) {
            int attack = optionalAttacker.get().getAttack();
            Player defender = optionalDefender.get();
            int health = defender.getHealth();

            defender.setHealth(health - attack);

            return playerService.save(defender);
        } else {
            return null;
        }
    }
}
