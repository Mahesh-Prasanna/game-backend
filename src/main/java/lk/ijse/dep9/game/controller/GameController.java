package lk.ijse.dep9.game.controller;
import lk.ijse.dep9.game.dto.ResponseDTO;
import lk.ijse.dep9.game.entity.Game;
import lk.ijse.dep9.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private ResponseDTO responseDTO;


    @PostMapping(value = "/saveGame")
    private ResponseEntity saveGame(@RequestParam("file") MultipartFile file, @RequestParam("gameName") String gameName,@RequestParam("gameDate") String gameDate) throws IOException {
        String res = gameService.saveGame(file, gameName, gameDate);
        if (res.equals("01")) {
            responseDTO.setCode("01");
            responseDTO.setMessage("Success");
            responseDTO.setContent(res);
            return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
        }
        else {
            responseDTO.setCode("02");
            responseDTO.setMessage("Error");
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/getAllGames")
    private ResponseEntity getAllGames(){
        List<Game> games = gameService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/deleteGame")
    private ResponseEntity deleteGame(@RequestParam("id") String id){
        String res = gameService.deleteGame(id);
        if (res.equals("00")){
            responseDTO.setCode("00");
            responseDTO.setMessage("Duplicated");
            responseDTO.setContent(res);
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        } else if (res.equals("01")) {
            responseDTO.setCode("01");
            responseDTO.setMessage("Deleted");
            responseDTO.setContent(res);
            return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
        }
        else {
            responseDTO.setCode("02");
            responseDTO.setMessage("Error");
            responseDTO.setContent(res);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
