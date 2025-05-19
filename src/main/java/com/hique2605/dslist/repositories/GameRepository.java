package com.hique2605.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hique2605.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	//consulta com banco, varias opercaoes basicas, Framework top
}
