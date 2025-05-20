package com.hique2605.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hique2605.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	//consulta com banco, varias opercaoes basicas, Framework top
}
