package pe.edu.pucp.data.viewer.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Emilio on 7/6/2016.
 */
@Data
public class Line {
    private String label;
    private List<Integer> x;
    private List<Integer> y;
}
