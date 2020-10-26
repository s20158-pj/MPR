package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

        public List<Player> findAll(){
            return List.of(new Player("Wojtek",100, 10, 5));
        }

}
