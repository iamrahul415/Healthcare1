package com.example.healthcare;

import static com.example.healthcare.R.layout.multi_lines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name: Ajit Sasta", "Hospital Address: Pimpari", "Exp : 5yrs", "Mobile Number: 9898989898","600"},
                    {"Doctor Name: Prasad Pawar", "Hospital Address: Niqdi", "Exp : 15yrs", "Mobile Number: 7898986898","900"},
                    {"Doctor Name: Swapnil Kale", "Hospital Address: Pune", "Exp : 8yrs", "Mobile Number: 8898969698","1000"},
                    {"Doctor Name: Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp : 6yrs", "Mobile Number: 9798960898","500"},
                    {"Doctor Name: Ashok Panda", "Hospital Address: Katraj", "Exp : 7yrs", "Mobile Number: 9998981214","800"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Sajiya Ahemad", "Hospital Address : Pimpari", "Exp : 5yrs", "Mobile Number: 9898989898","1600"},
                    {"Doctor Name: Pradip Pawar", "Hospital Address : Niqdi", "Exp : 15yrs", "Mobile Number: 7898986898","900"},
                    {"Doctor Name: Subham Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile Number: 8898969698","1000"},
                    {"Doctor Name: Deepak Ratre", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile Number: 9798000898","500"},
                    {"Doctor Name: Ashok Bhai", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile Number: 9998981214","800"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Ajit Patidar", "Hospital Address : Pimpari", "Exp : 5yrs", "Mobile Number: 9898989898","600"},
                    {"Doctor Name: Poonam Raj", "Hospital Address : Niqdi", "Exp : 15yrs", "Mobile Number: 7898986898","1500"},
                    {"Doctor Name: Avinash Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile Number: 8898777698","1000"},
                    {"Doctor Name: Pandey Deshmukh", "Hospital Address : Chinchwad", "Exp : 16yrs", "Mobile Number: 9798960898","500"},
                    {"Doctor Name: Ashok Bhatra", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile Number: 9998981214","800"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Amol Gawade", "Hospital Address : Pimpari", "Exp : 5yrs", "Mobile Number: 9898989898","600"},
                    {"Doctor Name: Prasad Pawar", "Hospital Address : Niqdi", "Exp : 15yrs", "Mobile Number: 7898986898","900"},
                    {"Doctor Name: Nilesh Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile Number: 8898659698","1000"},
                    {"Doctor Name: Deepak Dev", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile Number: 9798960898","500"},
                    {"Doctor Name: Ashok Singh", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile Number: 9998981214","800"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Nilesh Borate", "Hospital Address : Pimpari", "Exp : 5yrs", "Mobile Number: 9898989898","600"},
                    {"Doctor Name: Pankaj Pawar", "Hospital Address : Niqdi", "Exp : 15yrs", "Mobile Number: 7898986898","900"},
                    {"Doctor Name: Swapnil lele", "Hospital Address : Pune", "Exp : 8yrs", "Mobile Number: 8898969698","1000"},
                    {"Doctor Name: Deepak Kumar", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile Number: 9791230898","500"},
                    {"Doctor Name: Rahul Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile Number: 9998981214","800"},
            };
    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }});

        list = new ArrayList();
        for(int i=0; i<doctor_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
         );

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdopterView, View view, int i, long l) {
                Intent it =  new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}