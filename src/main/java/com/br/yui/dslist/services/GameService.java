package com.br.yui.dslist.services;

import com.br.yui.dslist.dto.GameDTO;
import com.br.yui.dslist.dto.GameMinDTO;
import com.br.yui.dslist.entities.Game;
import com.br.yui.dslist.projections.GameMinProjection;
import com.br.yui.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository  = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> listGame = gameRepository.findAll();
        List<GameMinDTO> dto = listGame.stream()
                .map(x -> new GameMinDTO(x))
                .toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
       Game result = gameRepository.findById(id).get();
       GameDTO dto = new GameDTO(result);
       return dto;

    }


    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream()
                .map(x -> new GameMinDTO(x))
                .toList();

    }

}
