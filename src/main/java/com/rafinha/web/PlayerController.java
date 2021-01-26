package com.rafinha.web;

import com.rafinha.data.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/players")
public class PlayerController {

    private PlayersRepository playersRepository;

    @Autowired
    public PlayerController(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String players(Map model) {
        model.put("playerList", playersRepository.findPlayers("FC Barcelona"));
        return "players";
    }
}
