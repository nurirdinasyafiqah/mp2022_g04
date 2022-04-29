package com.example.mprightinn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
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
    TextView Name, PhoneNo, TotalGuest, RoomType, Date, TotalPrice, Duration, NumberRoom;
    Button Confirm;
    String iName, iPhoneNo, iTotalGuest, iRoomType, iDate, iTotalPrice, iDuration, iNumberRoom;
    Double dTotalPrice;
    int nnumberroom, nduration;
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
        Duration = findViewById(R.id.tv_duration);
        NumberRoom = findViewById(R.id.tvNumberRoom);

        iName = getIntent().getStringExtra("keyname");
        iPhoneNo = getIntent().getStringExtra("keyphoneno");
        iTotalGuest = getIntent().getStringExtra("keytotalguest");
        iRoomType = getIntent().getStringExtra("keyroomtype");
        iDate = getIntent().getStringExtra("keydate");
        iDuration = getIntent().getStringExtra("keyduration");
        iNumberRoom = getIntent().getStringExtra("keynumberroom");

        Name.setText(iName);
        PhoneNo.setText(iPhoneNo);
        TotalGuest.setText(iTotalGuest);
        RoomType.setText(iRoomType);
        Date.setText(iDate);
        Duration.setText(iDuration);
        NumberRoom.setText(iNumberRoom);

        calculateRoomPrice();
        TotalPrice.setText(iTotalPrice);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = firebaseDatabase.getReference("Booking Detail").child(firebaseAuth.getUid());
                ConfirmBooking confirmBooking = new ConfirmBooking(iName, iPhoneNo, iTotalGuest, iRoomType, iDate, iTotalPrice, iDuration, iNumberRoom);
                databaseReference.setValue(confirmBooking);
                //Toast.makeText(ConfirmActivity.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                addNotification();
                finish();
                startActivity(new Intent(ConfirmActivity.this, SecondActivity.class));
            }
        });
    }

    public void calculateRoomPrice (){
        nnumberroom = Integer.parseInt(iNumberRoom);
        nduration = Integer.parseInt(iDuration);


        if (iRoomType.equals("Single Room")){
            dTotalPrice = (nnumberroom*120.00)*nduration;
        }else if (iRoomType.equals("Double Room")) {
            dTotalPrice = (nnumberroom*240.00)*nduration;
        }else if (iRoomType.equals("Triple Room")) {
            dTotalPrice = (nnumberroom*360.00)*nduration;
        }else if (iRoomType.equals("Queen Room")) {
            dTotalPrice = (nnumberroom*350.00)*nduration;
        }else if (iRoomType.equals("King Room")) {
            dTotalPrice = (nnumberroom*400.00)*nduration;
        }else if (iRoomType.equals("Connecting Room")) {
            dTotalPrice = (nnumberroom*440.00)*nduration;
        }else if (iRoomType.equals("Studio Room")) {
            dTotalPrice = (nnumberroom*600.00)*nduration;
        }else if (iRoomType.equals("Master Suite Room")) {
            dTotalPrice = (nnumberroom*2000.00)*nduration;
        }

        iTotalPrice = String.format("%.2f", dTotalPrice);
    }

    private void addNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.star_on)
                .setContentTitle("Right Inn - HOTEL BOOKING APP")
                .setContentText("Your hotel room booking is confirmed!");

        Intent notificationIntent = new Intent(this, Receipt.class);

        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}