  package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

  public class MainActivity extends AppCompatActivity {


       ListView listView ;

      public void generatetimeTables(int timeTableNumber  ){
          ArrayList<String> mytimetable = new ArrayList<String>();
          for (int i = 1;i<=10;i++){
              mytimetable.add(Integer.toString(i*timeTableNumber));
          }
          ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mytimetable);
          listView.setAdapter(arrayAdapter);
      }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int startingposition = 1;
        int max = 20;
        generatetimeTables(startingposition);
        SeekBar seekBar = findViewById(R.id.seekBar);
        listView= findViewById(R.id.listView);


        seekBar.setMax(max);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timeTableNumber;
                if(progress<min){
                    timeTableNumber=min ;
                    seekBar.setProgress(min);
                }else {
                    timeTableNumber=progress;
                }
                generatetimeTables(timeTableNumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}