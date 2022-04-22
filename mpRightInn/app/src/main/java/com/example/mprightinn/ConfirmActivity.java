package com.example.mprightinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmActivity extends AppCompatActivity {
    TextView Name, PhoneNo, TotalGuest, RoomType, Date, TotalPrice;
    Button Confirm;
    String iName, iPhoneNo, iTotalGuest, iRoomType, iDate, iTotalPrice;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        Name = findViewById(R.id.tvName1);
        PhoneNo = findViewById(R.id.tvPhoneNo1);
        TotalGuest = findViewById(R.id.tvTotalGuest1);
        RoomType = findViewById(R.id.tvRoomType1);
        Date = findViewById(R.id.tvDate1);
        TotalPrice = findViewById(R.id.tvTotalPrice);
        Confirm = findViewById(R.id.btnConfirm);

         iName = getIntent().getStringExtra("keyName");
         iPhoneNo = getIntent().getStringExtra("keyPhoneNo");
         iTotalGuest = getIntent().getStringExtra("keyTotalGuest");
         iRoomType = getIntent().getStringExtra("keyRoomType");
         iDate = getIntent().getStringExtra("keyDate");

        Name.setText(iName);
        PhoneNo.setText(iPhoneNo);
        TotalGuest.setText(iTotalGuest);
        RoomType.setText(iRoomType);
        Date.setText(iDate);

        calculateRoomPrice(iRoomType);
        TotalPrice.setText(iTotalPrice);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = firebaseDatabase.getReference("Booking Detail").child(firebaseAuth.getUid());
                ConfirmBooking confirmBooking = new ConfirmBooking(iName, iPhoneNo, iTotalGuest, iRoomType, iDate, iTotalPrice);
                databaseReference.setValue(confirmBooking);
                Toast.makeText(ConfirmActivity.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(ConfirmActivity.this, SecondActivity.class));
            }
        });
    }


    public void calculateRoomPrice (String iRoomType){
        this.iRoomType = iRoomType;
        if (iRoomType.equals("SINGLE")){
            iTotalPrice = "RM120";
        }else if (iRoomType.equals("KING")) {
            iTotalPrice = "RM220";
        }else if (iRoomType.equals("PREMIUM")) {
            iTotalPrice = "RM320";
        }

    }
}