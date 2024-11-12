package com.br.yui.dslist.services;

import com.br.yui.dslist.dto.GameListDTO;
import com.br.yui.dslist.entities.GameList;
import com.br.yui.dslist.repositories.GameListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository){
        this.gameListRepository  = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> listGame = gameListRepository.findAll();
        List<GameListDTO> dto = listGame.stream()
                .map(x -> new GameListDTO(x))
                .toList();
        return dto;
    }


}
