package HomeWork7.view;

import HomeWork7.controller.WeatherController;
import HomeWork7.model.WeatherResponse;

import java.io.IOException;
import java.util.Scanner;

public class WeatherViewer {

    public static void consoleView(WeatherResponse data){
        System.out.println(data);
    }

    public static void processCity() throws IOException {
        // бесконечный цикл опроса ввода из консоли.
        while (true) {
            System.out.println("--= Введите город (для выхода из программы наберите 'exit') =--");
            Scanner sc = new Scanner(System.in);
            String city = sc.nextLine();
            if (city.equals("exit")) {
                break;
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
