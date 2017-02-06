package pe.edu.pucp.data.viewer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Emilio on 7/6/2016.
 */
@SpringBootApplication
@MapperScan(basePackages = "pe.edu.pucp.data.viewer.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
