package pl.pjatk.gameplay.player.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.model.Player;

import java.util.Optional;

@Service
public class DamageService {

//    private PlayerService playerService;
//
//    public DamageService(PlayerService playerService) {
//        this.playerService = playerService;
//    }
//
//    public Player damage(Long attackerId, Long defenderId) {
//        Optional<Player> optionalAttacker = playerService.findByID(attackerId);
//        Optional<Player> optionalDefender = playerService.findByID(defenderId);
//
//        if (optionalAttacker.isPresent() && optionalDefender.isPresent()) {
//            int attack = optionalAttacker.get().getAttack();
//            Player defender = optionalDefender.get();
//            int health = defender.getHealth();
//
//            defender.setHealth(health - attack);
//
//            return playerService.save(defender);
//        } else {
//            return null;
//        }
//    }

    public Player heal(Player player, int points){ ;

        player.setHealth(player.getHealth() + points);
        return player;
    }

    public Player manaRegen(Player player, int points){ ;

        player.setMana(player.getMana() + points);
        return player;
    }

    public Player boost(Player player){ ;

        player.setAttack(player.getAttack() + 5);
        return player;
    }

    public Player poison(Player player){ ;

        player.setHealth(player.getHealth() - 5);
        return player;
    }

    public Player curse(Player player){ ;

        player.setAttack(player.getAttack() - 10);
        return player;
    }

    public Player attack(Player attacker, Player defender) {
        defender.setHealth(
                defender.getHealth() - attacker.getAttack()
        );
        return defender;
    }
}
