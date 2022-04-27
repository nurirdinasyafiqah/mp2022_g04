package com.example.mprightinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Booking extends AppCompatActivity {
    EditText Name, PhoneNo, TotalGuest, Date, Duration, NumberRoom;
    Button Submit;
    ImageButton setDate;
    String idate, iname, iphoneno, itotalguest, iroomtype, iduration, inumberroom;
    Spinner RoomType;
    String []Room_Type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Submit = findViewById(R.id.btnSubmit);
        Name = findViewById(R.id.etName);
        PhoneNo = findViewById(R.id.etPhoneNo);
        TotalGuest = findViewById(R.id.etGuest);
        RoomType = findViewById(R.id.spinnerRoomType);
        Date = findViewById(R.id.etDate);
        setDate = findViewById(R.id.btn_date);
        Duration = findViewById(R.id.etDuration);
        NumberRoom = findViewById(R.id.etNumberRoom);

        Room_Type = getResources().getStringArray(R.array.roomtype_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item, Room_Type);
        RoomType.setAdapter(adapter);
        RoomType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index = adapterView.getSelectedItemPosition();
                iroomtype = Room_Type[index];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Booking.this, Calender.class));

            }
        });

        idate = getIntent().getStringExtra("keydate");
        Date.setText(idate);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 iname = Name.getText().toString();
                 iphoneno = PhoneNo.getText().toString();
                 itotalguest = TotalGuest.getText().toString();
                 iduration = Duration.getText().toString();
                 inumberroom = NumberRoom.getText().toString();

                Intent intent = new Intent(Booking.this, ConfirmActivity.class);
                intent.putExtra("keyname", iname);
                intent.putExtra("keyphoneno", iphoneno);
                intent.putExtra("keytotalguest", itotalguest);
                intent.putExtra("keyroomtype", iroomtype);
                intent.putExtra("keydate", idate);
                intent.putExtra("keyduration", iduration);
                intent.putExtra("keynumberroom", inumberroom);

                startActivity(intent);

            }
        });
    }
}