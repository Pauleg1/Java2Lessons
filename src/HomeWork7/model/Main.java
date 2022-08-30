package HomeWork7.model;

import java.util.*;

public class Main{             // основные погодные характеристики
    Double temp;
    Double feels_like;
    Double temp_min;
    Double temp_max;
    Integer pressure;
    Integer sea_level;
    Integer grnd_level;
    Integer humidity;
    Double temp_kf;

    public Main() {
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getSea_level() {
        return sea_level;
    }

    public void setSea_level(Integer sea_level) {
        this.sea_level = sea_level;
    }

    public Integer getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(Integer grnd_level) {
        this.grnd_level = grnd_level;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(Double temp_kf) {
        this.temp_kf = temp_kf;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }
}
