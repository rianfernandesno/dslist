package com.br.yui.dslist.controllers;

import com.br.yui.dslist.dto.GameMinDTO;
import com.br.yui.dslist.entities.Game;
import com.br.yui.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private  GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }
    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
