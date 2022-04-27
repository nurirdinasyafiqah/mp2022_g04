package com.example.mprightinn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Receipt extends AppCompatActivity {

    TextView Name, PhoneNo, TotalGuest, RoomType, Date, TotalPrice, Duration, NumberRoom;
    Button Next;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        Name = findViewById(R.id.tvRname);
        PhoneNo = findViewById(R.id.tvRphoneN);
        TotalGuest = findViewById(R.id.tvRtotalG);
        TotalPrice = findViewById(R.id.tvRtotalPrice);
        RoomType = findViewById(R.id.tvRroomtype);
        Date = findViewById(R.id.tvRdate);
        Duration = findViewById(R.id.tvRduration);
        NumberRoom = findViewById(R.id.tvRnumberRoom);
        Next = findViewById(R.id.btnNext);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Booking Detail").child(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ConfirmBooking confirmBooking = snapshot.getValue(ConfirmBooking.class);
                Name.setText("Name : "+ confirmBooking.getName());
                PhoneNo.setText("Phone Number : "+ confirmBooking.getPhoneNo());
                TotalGuest.setText("Total Guest : "+ confirmBooking.getTotalGuest());
                TotalPrice.setText("Total Price : RM "+ confirmBooking.getTotalPrice());
                RoomType.setText("Room Type : "+ confirmBooking.getRoomType());
                Date.setText("Date : "+ confirmBooking.getDate());
                Duration.setText("Duration : "+ confirmBooking.getDuration());
                NumberRoom.setText("Number Room : "+ confirmBooking.getNumberRoom());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Receipt.this, SecondActivity.class));
            }
        });
    }
}