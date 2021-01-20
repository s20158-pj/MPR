package pl.pjatk.gameplay.player.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.player.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class DamageServiceTest {

    private final DamageService damageService = new DamageService();

    @Test
    void didHealPlayerCorrectly(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        //when
        damageService.heal(player, 5);
        //then
        assertThat(player.getHealth()).isEqualTo(105);
    }

    @Test
    void shouldNotHealPlayer(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        int startHealth = player.getHealth();
        //when
        damageService.heal(player, 5);
        //then
        assertThat(player.getHealth()).isGreaterThanOrEqualTo(startHealth);
    }

    @Test
    void didManaRegenPlayerCorrectly(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        //when
        damageService.manaRegen(player, 10);
        //then
        assertThat(player.getMana()).isEqualTo(20);
    }

    @Test
    void shouldNotManaRegenPlayer(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        int startMana = player.getMana();
        //when
        damageService.heal(player, 10);
        //then
        assertThat(player.getMana()).isGreaterThanOrEqualTo(startMana);
    }

    @Test
    void isBoosted(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        int startAttack = player.getAttack();
        //when
        damageService.boost(player);
        //then
        assertThat(player.getAttack()).isEqualTo(startAttack + 5);
    }

    @Test
    void shouldNotBoost(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        int startAttack = player.getAttack();
        //when
        damageService.boost(player);
        damageService.boost(player);
        //then
        assertThat(player.getAttack()).isGreaterThan(startAttack + 5);
    }

    @Test
    void isPoisoned(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        int startHealth = player.getHealth();
        //when
        damageService.poison(player);
        //then
        assertThat(player.getHealth()).isEqualTo(startHealth - 5);
    }

    @Test
    void shouldNotPoison(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        int startHealth = player.getHealth();
        //when
        damageService.poison(player);
        damageService.poison(player);
        //then
        assertThat(player.getHealth()).isLessThan(startHealth - 5);
    }

    @Test
    void isCursed(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        int startAttack = player.getAttack();
        //when
        damageService.curse(player);
        //then
        assertThat(player.getAttack()).isEqualTo(startAttack - 10);
    }

    @Test
    void shouldNotCurse(){
        //given
        Player player = new Player(0L, "tester", 100, 100, 10);
        int startAttack = player.getAttack();
        //when
        damageService.curse(player);
        damageService.curse(player);
        //then
        assertThat(player.getAttack()).isLessThan(startAttack - 10);
    }

}
