package com.rafinha.data;

import com.rafinha.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayersRepository {
    List<Player> findPlayers(String clubName);
}
