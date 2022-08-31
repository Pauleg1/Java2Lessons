package HomeWork8.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import HomeWork8.model.*;
import HomeWork8.controller.WeatherController;

public class WeatherViewer {
    public static void consoleView(WeatherResponse data){
        System.out.println(data);
    }

    public static void processCity() throws IOException, SQLException {
        // бесконечный цикл опроса ввода из консоли.
        while (true) {
            System.out.println("--= Введите город (для выхода из программы наберите 'выход', для получения истории " +
                    "'история <город>')" +
                    " " +
                    "=--");
            Scanner sc = new Scanner(System.in);
            String city = sc.nextLine();
            if (city.equals("выход")) {
                break;
            } else if (city.contains("история")) {
                String[] buff = city.split(" ");
                city = buff[1];
                WeatherController.printCityHistory(city);
            } else {
                WeatherResponse weather = WeatherController.getWeatherFromCityV2(city);
                if (weather.isEmpty()) {
                    System.out.println("Такого города нет в OpenWeatherMap или данные по нему не могут быть предоставлены");
                } else {
                    consoleView(WeatherController.getWeatherFromCityV2(city));
                }
            }
        }
    }


}
