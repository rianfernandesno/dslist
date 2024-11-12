package com.br.yui.dslist.dto;

import com.br.yui.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    private GameListDTO(){}

    public GameListDTO(GameList gameList) {
        this.id = gameList.getId();;
        this.name = gameList.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
