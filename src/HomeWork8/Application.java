package HomeWork8;

import java.io.IOException;
import java.sql.SQLException;

import HomeWork8.view.WeatherViewer;


public class Application {
    public static void main(String[] args) throws IOException, SQLException {
        // Консольный интерфейс
        WeatherViewer.processCity();
    }

}
