package com.hique2605.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hique2605.dslist.dto.GameListDTO;
import com.hique2605.dslist.entities.GameList;
import com.hique2605.dslist.projections.GameMinProjection;
import com.hique2605.dslist.repositories.GameListRepository;
import com.hique2605.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
		
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){	//por enquanto assim
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;	
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinatioIndex)	{
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinatioIndex,obj);
		
		//achar min e max
		int min = sourceIndex < destinatioIndex ? sourceIndex : destinatioIndex;
		//se o sourceIndex for menor que o destino entao o min é o source caso contrario : (else) destination
		int max = sourceIndex < destinatioIndex ? destinatioIndex : sourceIndex;
		
		for (int i = min; i<= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
	
	
	
	
	
}
