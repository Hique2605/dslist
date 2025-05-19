package com.hique2605.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hique2605.dslist.dto.GameMinDTO;
import com.hique2605.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController	{
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}

	
	
	
	
}
