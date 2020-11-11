package pl.pjatk.gameplay.player.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

import java.util.ArrayList;
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

    public Optional<Player> findByID(int id){
        List<Player> players = new ArrayList<>();
        players.add(new Player(1L, "Player1",100, 10, 5));
        players.add(new Player(2L, "Player2",100, 10, 5));
        players.add(new Player(3L, "Player3",100, 10, 5));

        return players.stream().filter(player -> player.getId() == id).findFirst();

//        for (Player player : players) {
//            if (player.getId() == id) {
//                return player;
//            }
//        }
//        return new Player();
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

}
