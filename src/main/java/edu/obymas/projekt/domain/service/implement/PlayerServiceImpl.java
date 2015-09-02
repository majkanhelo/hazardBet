package edu.obymas.projekt.domain.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.obymas.projekt.domain.dao.PlayerDao;
import edu.obymas.projekt.domain.model.Player;
import edu.obymas.projekt.domain.service.PlayerService;


@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDao playerDao;
   
    @Override
    public double getPlayerAccount(long id) {
    	return playerDao.getPlayerAccount(id);
    }
    
    @Override
	public void updatePlayerAccount(Player player){
    	playerDao.update(player);
    }
    
    @Override
    public void createPlayer(long userId){
    	Player player=new Player();
    	player.setId(userId);
    	player.setAccount(200);
    	
    	playerDao.create(player);
    }
    
    @Override
    public Player findPlayer(long id) {
    	return playerDao.find(id);
    }
    
    @Override 
    public void deletePlayer(long id) {
    	playerDao.delete(id);
    }
}
