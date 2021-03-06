package pl.pjatk.gameplay.player.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.service.DamageService;
import pl.pjatk.gameplay.player.service.PlayerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;
    private DamageService damageService;

    public PlayerController(PlayerService playerService, DamageService damageService) {
        this.playerService = playerService;
        this.damageService = damageService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/test")
    public ResponseEntity<String> findString() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Player>> findByID(@PathVariable Long id) {
        Optional<Player> byId = playerService.findByID(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player){
        return ResponseEntity.ok(playerService.save(player));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        playerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@RequestBody Player player, @PathVariable Long id){
        return ResponseEntity.ok(playerService.update(id, player));
    }

    @GetMapping("/health/{health}/{nickname}")
    public ResponseEntity<List<Player>> findByID(@PathVariable int health, @PathVariable String nickname) {
        List<Player> byId = playerService.findByHealth(health, nickname);
        return ResponseEntity.ok(byId);
    }

//    @PutMapping("/{id}/{id2}")
//    public ResponseEntity<Player> damage(@PathVariable Long id, @PathVariable Long id2) {
//        return ResponseEntity.ok(damageService.damage(id, id2));
//    }
}
