package com.br.yui.dslist.services;

import com.br.yui.dslist.dto.GameMinDTO;
import com.br.yui.dslist.entities.Game;
import com.br.yui.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository  = gameRepository;
    }
    public List<GameMinDTO> findAll(){
        List<Game> listGame = gameRepository.findAll();
        List<GameMinDTO> dto = listGame.stream()
                .map(x -> new GameMinDTO(x))
                .toList();
        return dto;
    }
}
