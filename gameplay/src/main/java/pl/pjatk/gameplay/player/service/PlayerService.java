package pl.pjatk.gameplay.player.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.model.Message;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private DamageService damageService;

    public PlayerService(PlayerRepository playerRepository, DamageService damageService) {
        this.playerRepository = playerRepository;
        this.damageService = damageService;
    }

    public List<Player> findAll(){
            return playerRepository.findAll();
        }

    public Optional<Player> findByID(Long id){
        if (id == 10) {
            throw new RuntimeException();
        } else {
            return playerRepository.findById(id);
        }
    }

    public Player save(Player player) {

        player.getMessageList().add(new Message("Some content 1", player));
        player.getMessageList().add(new Message("Some content 2", player));

        return playerRepository.save(player);
    }

    public void delete(Long id){
        playerRepository.deleteById(id);
    }

    public Player update(Long id, Player updatedPlayer){
//        updatedPlayer.setId(id);
        if (findByID(updatedPlayer.getId()).isPresent()) {
            return playerRepository.save(updatedPlayer);
        } else {
            return null;
        }
//        Optional<Player> playerOptional = playerRepository.findById(id);
//        if (playerOptional.isPresent()) {
//            Player player = playerOptional.get();
//            player.setNickname(updatedPlayer.getNickname());
//            player.setAttack(updatedPlayer.getAttack());
//            player.setHealth(updatedPlayer.getHealth());
//            player.setMana(updatedPlayer.getMana());
//            return playerRepository.save(player);
//        } else {
//            return null;
//        }
    }

    public Player attack(Long attackerId, Long defenderId) {
        Player attacker = findByID(attackerId).get();
        Player defender = findByID(defenderId).get();
        defender = damageService.attack(attacker, defender);
        playerRepository.save(defender);
        return defender;
    }

    public List<Player> findByHealth(int health, String nickname) {
        return playerRepository.findByHealthAndNickname(health, nickname);
    }
}
