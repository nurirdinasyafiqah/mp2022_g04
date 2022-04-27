package com.example.mprightinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoomtType extends AppCompatActivity {

    private Button singleRoom, doubleRoom, tripleRoom, queenRoom, kingRoom, connectingRoom, studioRoom, masterRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomt_type);

        singleRoom = (Button) findViewById(R.id.btn_single);
        doubleRoom = (Button) findViewById(R.id.btn_double);
        tripleRoom = (Button) findViewById(R.id.btn_triple);
        queenRoom = (Button) findViewById(R.id.btn_queen);
        kingRoom = (Button) findViewById(R.id.btn_king);
        connectingRoom = (Button) findViewById(R.id.btn_connecting);
        studioRoom = (Button) findViewById(R.id.btn_studio);
        masterRoom = (Button) findViewById(R.id.btn_master);

        singleRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singleRoom();
            }
        });
        doubleRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doubleRoom();
            }
        });
        tripleRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripleRoom();
            }
        });
        queenRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queenRoom();
            }
        });
        kingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kingRoom();
            }
        });
        connectingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectingRoom();
            }
        });
        studioRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studioRoom();
            }
        });
        masterRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masterRoom();
            }
        });

    }
    public void singleRoom (){
        startActivity(new Intent(RoomtType.this, Booking.class));
    }
    public void doubleRoom (){
        startActivity(new Intent(RoomtType.this, Booking.class));
    }
    public void tripleRoom (){
        startActivity(new Intent(RoomtType.this, Booking.class));
    }
    public void queenRoom (){
        startActivity(new Intent(RoomtType.this, Booking.class));
    }
    public void kingRoom (){
        startActivity(new Intent(RoomtType.this, Booking.class));
    }
    public void connectingRoom (){
        startActivity(new Intent(RoomtType.this, Booking.class));
    }
    public void studioRoom (){
        startActivity(new Intent(RoomtType.this, Booking.class));
    }
    public void masterRoom (){
        startActivity(new Intent(RoomtType.this, Booking.class));
    }

}