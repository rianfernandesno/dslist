package com.br.yui.dslist.controllers;

import com.br.yui.dslist.dto.GameListDTO;
import com.br.yui.dslist.services.GameListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private GameListService gameListService;

    public GameListController(GameListService gameListService){
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }


}
