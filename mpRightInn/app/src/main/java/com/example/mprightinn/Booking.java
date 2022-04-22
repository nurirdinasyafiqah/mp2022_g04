package com.example.mprightinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Booking extends AppCompatActivity {
    EditText Name, PhoneNo, TotalGuest, RoomType, Date;
    Button Submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Submit = findViewById(R.id.btnSubmit);
        Name = findViewById(R.id.etName);
        PhoneNo = findViewById(R.id.etPhoneNo);
        TotalGuest = findViewById(R.id.etGuest);
        RoomType = findViewById(R.id.etRoomType);
        Date = findViewById(R.id.etDate);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iName = Name.getText().toString();
                String iPhoneNo = PhoneNo.getText().toString();
                String iTotalGuest = TotalGuest.getText().toString();
                String iRoomType = RoomType.getText().toString();
                String iDate = Date.getText().toString();

                Intent intent = new Intent(Booking.this, ConfirmActivity.class);
                intent.putExtra("keyName", iName);
                intent.putExtra("keyPhoneNo", iPhoneNo);
                intent.putExtra("keyTotalGuest", iTotalGuest);
                intent.putExtra("keyRoomType", iRoomType);
                intent.putExtra("keyDate", iDate);
                startActivity(intent);

            }
        });
    }
}