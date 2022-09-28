package com.example.learningfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CheckingPage extends AppCompatActivity {

    EditText SEARCH;
    Button FIND;
    TextView FIRST, LAST, ROLL, emm, bll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_page);

        SEARCH = (EditText) findViewById(R.id.Search);
        FIND = (Button) findViewById(R.id.Find);
        FIRST = (TextView) findViewById(R.id.First);
        LAST = (TextView) findViewById(R.id.Last);
        ROLL = (TextView) findViewById(R.id.Roll);
        emm = (TextView) findViewById(R.id.EMAIL);
        bll = (TextView) findViewById(R.id.BLOOD);

        FIND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SHOWSTUDENTS();
            }
        });
    }
    private void SHOWSTUDENTS()
    {
        String search = SEARCH.getText().toString().trim();
        DatabaseReference ForShowData = FirebaseDatabase.getInstance().getReference("Students");
        Query CheckStudents = ForShowData.orderByChild("id").equalTo(search);
        CheckStudents.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String First = snapshot.child(search).child("firstname").getValue(String.class);
                    String last = snapshot.child(search).child("lastname").getValue(String.class);
                    String blo = snapshot.child(search).child("blood_group").getValue(String.class);
                    String em = snapshot.child(search).child("email").getValue(String.class);
                    FIRST.setText(First);
                    LAST.setText(last);
                    emm.setText(em);
                    bll.setText(blo);
                    ROLL.setText(search);
                }
                else
                {
                    FIRST.setText("ID Doesn't match");
                    LAST.setText("Please Try Different ID");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}