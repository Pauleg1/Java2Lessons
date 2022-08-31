package HomeWork8.model;

import java.util.*;

public class WeatherResponse {    // Полный ответ по форме 5 дневного
    String cod;
    Integer message;
    Integer cnt;
    List<SituateWeather> list;
    City city;

    // конструкторы и геттеры
    public WeatherResponse() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<SituateWeather> getList() {
        return list;
    }

    public void setList(List<SituateWeather> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isEmpty(){
        if (this.city==null||this.list==null){
            return true;
        } else {
            return false;
        }
    }

    // преобразование в строку
    @Override
    public String toString() {
        if (isEmpty()) return "";
        String result = "Ответ сервера погоды:\n" +
                "\tМесто: " + city + ".\n\tПрогноз погоды на 5 дней (детализация 3 часа):\n"+ list;
        return result.replace("[","").replace("]","");
    }
}
