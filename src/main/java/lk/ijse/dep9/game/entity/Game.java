package lk.ijse.dep9.game.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gameName;
    private String gameDate;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public Game(String gameName, String gameDate, String image) {
        this.gameName = gameName;
        this.gameDate = gameDate;
        this.image = image;
    }
}
