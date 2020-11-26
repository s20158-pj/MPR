package pl.pjatk.gameplay.player.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll(){
            return playerRepository.findAll();
        }

    public Optional<Player> findByID(Long id){
        return playerRepository.findById(id);
    }

    public Player save(Player player) {
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
    }
}
