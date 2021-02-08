package pl.pjatk.gameplay.player.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.repository.PlayerRepository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private Player player;

    @InjectMocks
    private PlayerService playerService;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all here");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each here");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all here");
    }

    @Test
    void isFindAllEmpty() {
        // given
        when(playerRepository.findAll()).thenReturn(List.of(new Player()));
        // when
        List<Player> all = playerService.findAll();
        // then
        assertThat(all).isNotEmpty();
    }

    @Test
    void findById() {
        // given
        when(playerRepository.findById(1L)).thenReturn(Optional.of(new Player()));
        // when
        Optional<Player> player = playerRepository.findById(1L);
        // then
        assertThat(player).isNotEmpty();
    }

    @Test
    void isSaved() {
        //given
        Player player = new Player("nick", 1, 2, 3, List.of());
        Player player2 = new Player(1L, "nick", 1, 2, 3);
        when(playerRepository.save(player)).thenReturn(player2);
        //when
        Player savedPlayer = playerRepository.save(player);
        //then
        assertThat(savedPlayer.getId()).isEqualTo(player2.getId());
    }

    @Test
    void wasDeleted() {
        //when
        playerRepository.deleteById(1L);
        //then
        verify(playerRepository, times(1)).deleteById(1L);
    }


}