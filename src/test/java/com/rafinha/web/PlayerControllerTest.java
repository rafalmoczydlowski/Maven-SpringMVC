package com.rafinha.web;

import com.rafinha.Player;
import com.rafinha.data.PlayersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControllerTest {

    @Test
    public void shouldShowBarcelonaPlayers() throws Exception {
        List<Player> playersList = createPlayersList();
        PlayersRepository mockRepo = mock(PlayersRepository.class);
        when(mockRepo.findPlayers("FC Barcelona")).thenReturn(playersList);

        PlayerController controller = new PlayerController(mockRepo);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("players.jsp")).build();
        mockMvc.perform(get("/players"))
                .andExpect(view().name("players"))
                .andExpect(model().attributeExists("playerList"))
                .andExpect(model().attribute("playerList", hasItems(playersList.toArray())));
    }

    private List<Player> createPlayersList() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Lionel", "Messi", "FC Barcelona", "FW", 33));
        players.add(new Player("Cristiano", "Ronaldo", "Juventus", "FW", 35));
        players.add(new Player("Pawel", "Brozek", "Retired", "-", 40));
        players.add(new Player("Neymar", "Jr", "PSG", "FW", 28));
        players.add(new Player("Ansu", "Fati", "FC Barcelona", "FW", 18));
        players.add(new Player("Marc Andre", "ter Stegen", "FC Barcelona", "GK", 27));
        return players;
    }
}
