package com.br.yui.dslist.repositories;

import com.br.yui.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository  extends JpaRepository<GameList, Long> {
}
