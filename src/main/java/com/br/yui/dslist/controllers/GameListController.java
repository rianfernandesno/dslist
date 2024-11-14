package com.br.yui.dslist.controllers;

import com.br.yui.dslist.dto.GameListDTO;
import com.br.yui.dslist.dto.GameMinDTO;
import com.br.yui.dslist.dto.ReplacementDTO;
import com.br.yui.dslist.services.GameListService;
import com.br.yui.dslist.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private GameListService gameListService;
    private GameService gameService;

    public GameListController(
            GameListService gameListService,
            GameService gameService

    )
    {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }


    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO){
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
    }

}
