package pe.edu.pucp.data.viewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pucp.data.viewer.mapper.GraphicsMapper;
import pe.edu.pucp.data.viewer.model.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Emilio on 7/6/2016.
 */
@Service
public class GraphicsService {

    @Autowired
    GraphicsMapper mapper;

    private Line getLine(List<KeyValue> keyValues, String label){
        Line line = new Line();
        line.setLabel(label);

        List<Integer> xList = new ArrayList<>(keyValues.size());
        List<Integer> yList = new ArrayList<>(keyValues.size());

        for(KeyValue item: keyValues){
            xList.add(Integer.parseInt(item.getKey()));
            yList.add((int)Double.parseDouble(item.getValue()));
        }

        line.setX(xList);
        line.setY(yList);

        return line;
    }

    public List<Line> getTsunamiAndVolcanoLines() {
        List<KeyValue> tsunamiKeyValues = mapper.getTsunamiLostsInMillionDollars();
        List<KeyValue> volcanoKeyValues = mapper.getVolcanoLostsInMillionDollars();

        Line tsunamiLine = getLine(tsunamiKeyValues, "Tsunami");
        Line volcanoLine = getLine(volcanoKeyValues, "Volcano");

        List<Line> lines = new ArrayList<>(asList(tsunamiLine, volcanoLine));
        return lines;
    }

    public Ranking getTopAffectedCountries(){

        Ranking ranking = new Ranking();
        List<RankingRawData> rawItems = mapper.getTopAffectedCountries();

        List<String> labels = new ArrayList<>(13);

        RankingSerie serie1 = new RankingSerie();
        List<Integer> values1 = new ArrayList<>();

        RankingSerie serie2 = new RankingSerie();
        List<Integer> values2 = new ArrayList<>();

        RankingSerie serie3 = new RankingSerie();
        List<Integer> values3 = new ArrayList<>();

        for(RankingRawData item: rawItems){
            labels.add(item.getCountry());
            values1.add(item.getEvents());
            values2.add(item.getDeaths());
            values3.add(item.getHouses());
        }

        serie1.setLabel("Events");
        serie1.setValues(values1);

        serie2.setLabel("Deaths");
        serie2.setValues(values2);

        serie3.setLabel("Houses Destroyed");
        serie3.setValues(values3);

        List<RankingSerie> series = new ArrayList<>();
        series.add(serie1);
        series.add(serie2);
        series.add(serie3);

        ranking.setLabels(labels);
        ranking.setSeries(series);

        return ranking;
    }

}
