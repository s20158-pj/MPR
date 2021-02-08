package pl.pjatk.gameplay.player.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.service.PlayerService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTestIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PlayerService playerService;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/player")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void shouldMatchContent() throws Exception {
        mockMvc.perform(get("/player/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

    @Test
    void shouldNotFound() throws Exception {
        mockMvc.perform(get("/player/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldMatchContent2() throws Exception {
        playerService.save(new Player("nick", 1, 2, 3));

        mockMvc.perform(get("/player/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"nickname\":\"nick\",\"health\":1,\"attack\":2,\"mana\":3,\"messageList\":[{\"content\":\"Some content 1\"},{\"content\":\"Some content 2\"}]}")));
    }
}
