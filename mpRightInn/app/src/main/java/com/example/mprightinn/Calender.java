package com.example.mprightinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class Calender extends AppCompatActivity {

    DatePicker datePicker;
    Button chooseDate;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        datePicker = findViewById(R.id.date_picker);
        chooseDate = findViewById(R.id.btnChooseDate);

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth()+1;
                int year = datePicker.getYear();

                date = String.valueOf(day) + "/"+ String.valueOf(month) + "/" +String.valueOf(year);

                Intent intent = new Intent(Calender.this, Booking.class);
                intent.putExtra("keydate", date);
                startActivity(intent);

            }
        });
    }
}