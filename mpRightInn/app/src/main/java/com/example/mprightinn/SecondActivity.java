package com.example.mprightinn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout, BookRoom, RoomType, Receipt, Feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button) findViewById(R.id.btnLogout);
        BookRoom = (Button) findViewById(R.id.btnBookRoom);
        RoomType = (Button) findViewById(R.id.btnRoomType);
        Receipt = findViewById(R.id.btnReceipt);
        Feedback = findViewById(R.id.btnFeedback);


        BookRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookRoom();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
        RoomType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomType();
            }
        });
        Receipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, Receipt.class));
            }
        });
        Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, Feedback.class));
            }
        });
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, MainActivity.class));
    }

    public void BookRoom (){
        startActivity(new Intent(SecondActivity.this, Booking.class));
    }
    public void RoomType (){
        startActivity(new Intent(SecondActivity.this, RoomtType.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
            }
            case R.id.profileMenu:
                startActivity(new Intent( SecondActivity.this, ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}