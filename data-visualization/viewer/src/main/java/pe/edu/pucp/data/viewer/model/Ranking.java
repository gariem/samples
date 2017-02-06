package pe.edu.pucp.data.viewer.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Emilio on 7/6/2016.
 */
@Data
public class Ranking {

    List<String> labels;
    List<RankingSerie> series;

}
