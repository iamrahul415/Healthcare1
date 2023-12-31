package com.example.healthcare;

import static com.example.healthcare.R.id.editTextLDTextMultiLine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestdetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    TextView edDetails;
    Button btnAddToCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_testdetails);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.editTextLDTextMultiLine);

        btnAddToCart = findViewById(R.id.buttonLDAddToCard);
        btnBack = findViewById(R.id.buttonLDBack);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        String p=intent.getStringExtra("text3");
        tvTotalCost.setText("Total Cost= "+p+"/-");

       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LabTestdetailsActivity.this, LabTestActivity.class));
           }
       });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(p);

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                if(db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"Product Already Added", Toast.LENGTH_SHORT).show();
                }else{
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(),"Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestdetailsActivity.this,LabTestActivity.class));
                }
            }
        });
    }
}