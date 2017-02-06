package pe.edu.pucp.data.viewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.pucp.data.viewer.model.Line;
import pe.edu.pucp.data.viewer.model.Ranking;
import pe.edu.pucp.data.viewer.service.GraphicsService;

import java.util.List;

/**
 * Created by Emilio on 7/6/2016.
 */
@RestController
@RequestMapping("/data")
public class GraphicsController {

    @Autowired
    GraphicsService service;

    @RequestMapping("/lost")
    public List<Line> getLostsInMillionDollars() {
        return service.getTsunamiAndVolcanoLines();
    }

    @RequestMapping("/ranking")
    public Ranking getRanking() {

        return service.getTopAffectedCountries();

    }

}
