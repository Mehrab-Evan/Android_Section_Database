package com.example.learningfirebase;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname, id, email, blood;
    Button add;

    DatabaseReference LearningFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LearningFirebase = FirebaseDatabase.getInstance().getReference("Students");

        firstname = (EditText) findViewById(R.id.FirstName);
        lastname = (EditText) findViewById(R.id.LastName);
        id = (EditText) findViewById(R.id.ID);
        email = (EditText) findViewById(R.id.email);
        blood = (EditText) findViewById(R.id.blood);
        add = (Button) findViewById(R.id.ADD);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });
    }
    public void GotocheckPage(View vv)
    {
        Intent NotunPage = new Intent(this, CheckingPage.class);
        startActivity(NotunPage);
    }
    private void addStudent()
    {
        String fname = firstname.getText().toString().trim();
        String lname = lastname.getText().toString().trim();
        String number = id.getText().toString().trim();
        String em = email.getText().toString().trim();
        String bl = blood.getText().toString().trim();
        if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(number))
        {
            String ID;// = LearningFirebase.push().getKey();
            ID = number;
            InsertingValueToFirebase MyValues = new InsertingValueToFirebase(fname, lname, number, em, bl);
            LearningFirebase.child(ID).setValue(MyValues);
            Toast.makeText(this,"File Added", Toast.LENGTH_LONG).show();
            firstname.setText("");
            lastname.setText("");
            blood.setText("");
            email.setText("");
            id.setText("");
        }
        else
        {
            Toast.makeText(this, "No field should be empty",Toast.LENGTH_LONG).show();
        }
    }
}