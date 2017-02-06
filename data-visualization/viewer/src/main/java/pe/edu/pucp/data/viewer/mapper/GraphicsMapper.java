package pe.edu.pucp.data.viewer.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pe.edu.pucp.data.viewer.model.KeyValue;
import pe.edu.pucp.data.viewer.model.RankingRawData;

import java.util.List;

/**
 * Created by Emilio on 7/6/2016.
 */
public interface GraphicsMapper {

    @Results({
            @Result(property = "key", column = "KEY"),
            @Result(property = "value", column = "VALUE")
    })

    @Select("SELECT YEAR AS KEY,COALESCE(SUM(TOTAL_DAMAGE_MILLIONS_DOLLARS),0) AS VALUE FROM TSUNAMI_EVENT WHERE YEAR >=1970 " +
            "AND YEAR<2012 GROUP BY YEAR ORDER BY YEAR")
    List<KeyValue> getTsunamiLostsInMillionDollars();

    @Select("SELECT YEAR AS KEY,COALESCE(SUM(TOTAL_DAMAGE_MILLIONS_DOLLARS),0) AS VALUE FROM VOLCANO_ERUPTION WHERE YEAR >=1970 " +
            "AND YEAR<2012 GROUP BY YEAR ORDER BY YEAR")
    List<KeyValue> getVolcanoLostsInMillionDollars();

    @Results({
            @Result(property = "events", column = "NUM"),
            @Result(property = "deaths", column = "DEATHS"),
            @Result(property = "houses", column = "HOUSES")
    })

    @Select("SELECT COUNTRY,COUNT(1) AS NUM, COALESCE(SUM(TOTAL_DEATHS),0) AS DEATHS, COALESCE(SUM(TOTAL_HOUSES_DESTROYED),0) AS HOUSES FROM TSUNAMI_EVENT\n" +
            "WHERE COUNTRY !=''\n" +
            "GROUP BY COUNTRY\n" +
            "ORDER BY 2 DESC,3 DESC,4 DESC\n" +
            "LIMIT 10")
    List<RankingRawData> getTopAffectedCountries();
}
