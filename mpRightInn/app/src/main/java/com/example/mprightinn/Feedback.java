package com.example.mprightinn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Feedback extends AppCompatActivity {

    TextView tvFeedback;
    RatingBar ratingBar;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button sendFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        tvFeedback = findViewById(R.id.tv_feedback);
        ratingBar = findViewById(R.id.Rbar);
        sendFeedback = findViewById(R.id.btnSendFeedback);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Feedback").child(firebaseAuth.getUid());

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(v==0){
                    tvFeedback.setText("Dissapointed");
                }
                else if(v==1){
                    tvFeedback.setText("Very Dissatisfied");
                }
                else if(v==2){
                    tvFeedback.setText("Dissatisfied");
                }
                else if(v==3){
                    tvFeedback.setText("Okay");
                }
                else if(v==4){
                    tvFeedback.setText("Satisfied");
                }
                else if(v==5){
                    tvFeedback.setText("Very Satisfied");
                }
            }
        });

        sendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Feedback.this, MainActivity.class));
                Toast.makeText(Feedback.this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}