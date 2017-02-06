package pe.edu.pucp.data.viewer.model;

import lombok.Data;

/**
 * Created by Emilio on 7/6/2016.
 */
@Data
public class RankingRawData {
    private String country;
    private int events;
    private int deaths;
    private int houses;
}
