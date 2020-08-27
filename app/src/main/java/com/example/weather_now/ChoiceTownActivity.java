package com.example.weather_now;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChoiceTownActivity extends Activity {
    private static final String CITY_TO_SEARCH = "CITY_TO_SEARCH";
    List<City> cityList = new ArrayList<>();
    private EditText editText;
    Editable search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_town);

        editText = (EditText) findViewById(R.id.editText);
        RecyclerView rc = findViewById(R.id.cities);
        DataAdapter dataAdapter = new DataAdapter(this, cityList);
        rc.setAdapter(dataAdapter);
        setInitialData();

    }

    public void updateCity(View view){
        search = editText.getText();
        if(search.length() != 0){

            Intent updateCity = new Intent(ChoiceTownActivity.this, MainActivity.class);
            updateCity.putExtra(CITY_TO_SEARCH, search);
            startActivity(updateCity);
        }
    }

    private void setInitialData() {
        cityList.add(new City("Москва"));
        cityList.add(new City("Санкт-Петербург"));
        cityList.add(new City("Новосибирск"));
        cityList.add(new City("Сочи"));
        cityList.add(new City("Пермь"));
        cityList.add(new City("Чита"));
        cityList.add(new City("Тула"));
        cityList.add(new City("Владивосток"));
        cityList.add(new City("Хабаровск"));
        cityList.add(new City("Тверь"));
    }


}
