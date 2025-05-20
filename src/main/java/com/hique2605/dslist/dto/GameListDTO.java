package com.hique2605.dslist.dto;

import java.util.List;

import com.hique2605.dslist.entities.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {
	
	}

	public GameListDTO(GameList entity) {
		
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
	
}
