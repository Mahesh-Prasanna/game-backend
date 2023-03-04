package lk.ijse.dep9.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private int id;
    private String gameName;
    private String gameDate;
    private String image;
}
