package edu.binghamton.cs.unit_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Spinner dropdown;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropdown = findViewById(R.id.spinner);

        String[] items = new String[]{"Jupiter", "Mars", "Mercury", "Neptune", "Saturn", "Uranus", "Venus"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void convert(View v){
        EditText text = findViewById(R.id.editText);

        double mass = Double.parseDouble(text.getText().toString());
        String planet = dropdown.getSelectedItem().toString();
        double[] planet_gravity = new double[]{2.34, 0.38, 0.38, 1.12, 0.93, .92, .91};
        String[] items = new String[]{"Jupiter", "Mars", "Mercury", "Neptune", "Saturn", "Uranus", "Venus"};
        int i = 0;
        int planet_id = 0;
        for(String item: items){
            if(item == planet){
                planet_id = i;
            }
            i= i+1;
        }

        double weight = (planet_gravity[planet_id] * mass);

        Toast.makeText(MainActivity.this, Double.toString(weight), Toast.LENGTH_LONG).show();

    }
}
