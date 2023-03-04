package lk.ijse.dep9.game.service;

import lk.ijse.dep9.game.entity.Game;
import lk.ijse.dep9.game.repo.GameRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class GameService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GameRepo gameRepo;

    public String saveGame(MultipartFile file, String gameName, String gameDate) throws IOException {
        Game game = new Game();
        game.setGameName(gameName);
        game.setGameDate(gameDate);
        game.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        gameRepo.save(game);
        return "01";
    }
    public List<Game> getAllGames(){
        return gameRepo.findAll();
    }
    public String deleteGame(String id){
        if (gameRepo.existsById(Integer.valueOf(id))){
            gameRepo.deleteById(Integer.valueOf(id));
            return "01";
        }
        else {
            return "00";
        }
    }
}
