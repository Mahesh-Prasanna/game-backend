package lk.ijse.dep9.game.repo;

import lk.ijse.dep9.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Integer> {

}
