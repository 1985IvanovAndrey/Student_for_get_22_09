package com.example.student.service;

import com.example.student.dao.entity.weather.CloudEntity;
import com.example.student.dao.entity.weather.WeatherEntity;
import com.example.student.dto.WeatherDto;
import com.example.student.repository.WeatherRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    static final String JSON_FROM_OLESYA = "{\"Weather\":[{\"tempMax\":10,\"date\":\"Sun Sep 23 20:59:03 EEST 2018\",\"nameCity\":\"Dnipro\",\"pressure\":1018,\"CloudWeather\":[{\"description\":\"clear sky\",\"main\":\"Clear\"}],\"tempMin\":10}]}";

    private WeatherEntity constructWeatherDTOFromJSON_FROM_OLESYA() throws JSONException {

        JSONObject object = new JSONObject(JSON_FROM_OLESYA);

        WeatherEntity weatherEntity = new WeatherEntity();

        List<CloudEntity> cloudEntityList = new ArrayList<>();

        JSONArray getArray = object.getJSONArray("Weather");

        for (int i = 0; i < getArray.length(); i++) {
            JSONObject obj = getArray.getJSONObject(i);
            weatherEntity.setNameCity((String) obj.getString("nameCity"));
            weatherEntity.setDate((String) obj.getString("date"));
            weatherEntity.setPressure((Integer) obj.getInt("pressure"));
            weatherEntity.setTempMin((Integer) obj.getInt("tempMin"));
            weatherEntity.setTempMax((Integer) obj.getInt("tempMax"));

            JSONArray cloudWeather = obj.optJSONArray("CloudWeather");

            for (int j = 0; j < cloudWeather.length(); j++) {
                JSONObject obj2 = cloudWeather.getJSONObject(j);
                CloudEntity cloudEntity = new CloudEntity();
                cloudEntity.setDescription((String) obj2.getString("description"));
                cloudEntity.setMain((String) obj2.getString("main"));
                cloudEntityList.add(cloudEntity);
            }
        }
        weatherEntity.setCloudEntityList(cloudEntityList);
        System.out.println(weatherEntity);
        return weatherEntity;
    }


    public void addWeatherEntityToDB() throws JSONException {
        WeatherEntity weatherEntity = weatherRepository.saveAndFlush(constructWeatherDTOFromJSON_FROM_OLESYA());
    }

    public WeatherEntity getweatherEntity() {
        WeatherEntity weatherEntity = new WeatherEntity();
        for (WeatherEntity weatherEntity1 : weatherRepository.findAll()) {
            weatherEntity = weatherEntity1;
        }
        return weatherEntity;
    }

    public WeatherDto createWeatherDtoFromWeatherEntity(WeatherEntity weatherEntity) {

        WeatherDto weatherDto = new WeatherDto();

        WeatherDto.Weather weather=new WeatherDto.Weather();

        List<WeatherDto.Weather> weatherList = new ArrayList<>();

        for (int i = 0; i <weatherList.size() ; i++) {
           // WeatherDto.Weather weather=new WeatherDto.Weather();
            weather.setNameCity(weatherEntity.getNameCity());
            weather.setDate(weatherEntity.getDate());
            weather.setPressure(weatherEntity.getPressure());
            weather.setTempMax(weatherEntity.getTempMax());
            weather.setTempMin(weatherEntity.getTempMin());

        }
        weatherList.add(weather);

//        for (WeatherDto.Weather weather : weatherList) {
//            weather.setNameCity(weatherEntity.getNameCity());
//            weather.setDate(weatherEntity.getDate());
//            weather.setPressure(weatherEntity.getPressure());
//            weather.setTempMax(weatherEntity.getTempMax());
//            weather.setTempMin(weatherEntity.getTempMin());
//            weatherList.add(weather);
//            for (CloudEntity cloudEntity : weatherEntity.getCloudEntityList()) {
//                weather.setCloudWeather(weatherEntity.getCloudEntityList());
//                cloudEntity.
//
//            }
//            for (WeatherDto.CloudWeather cloudWeather : weather.getCloudWeather()) {
//                WeatherDto.CloudWeather cloudWeather1=new WeatherDto.CloudWeather();
//                for (CloudEntity entity : weatherEntity.getCloudEntityList()) {
//                    cloudWeather1.setDescription(entity.getDescription());
//                    cloudWeather1.setMain(entity.getMain());
//                }
//            }
//            weatherList.add(weather);
     //   }
        //weatherDto.setWeather(weatherList);

        System.out.println(weatherDto);
        System.out.println(weatherEntity);
        System.out.println(weatherList);
        return weatherDto;
    }
}