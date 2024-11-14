package com.br.yui.dslist.services;

import com.br.yui.dslist.dto.GameListDTO;
import com.br.yui.dslist.entities.GameList;
import com.br.yui.dslist.projections.GameMinProjection;
import com.br.yui.dslist.repositories.GameListRepository;
import com.br.yui.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private GameListRepository gameListRepository;
    private GameRepository gameRepository;

    public GameListService(
            GameListRepository gameListRepository,
            GameRepository gameRepository
    ){
        this.gameListRepository  = gameListRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> listGame = gameListRepository.findAll();
        List<GameListDTO> dto = listGame.stream()
                .map(x -> new GameListDTO(x))
                .toList();
        return dto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }


}
