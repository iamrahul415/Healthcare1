package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Uprise-03 1000IU Capsule", "", "", "", "50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
                    {"Vitamin B Complex Capsule", "", "", "", "448"},
                    {"Inlife Vitamin Wheat Germ Oil capsule", "", "", "", "539"},
                    {"Dolo 360 Tablet", "", "", "", "30"},
                    {"Crocin 360 Advance Tablet", "", "", "", "50"},
                    {"Strepsils Medicated Lozenges for sore Throat", "", "", "", "40"},
                    {"Tata 1mg Calcium + Vitamin D3", "", "", "","30"},
                    {"Feronia -XT Tablet", "", "", "", "130"},
            };

    private String[] package_details =
            {
                    "Building and keeping the bones & teeth Strong\n" +
                            "Reducing Fatigue/Stress and muscular pains\n" +
                            "Boosting immunity and increasing resistance against infection",
                    "chromium is an essential trace mineral that play an important role in helping insuling regulate blood glucose.",
                    "Provides relief from vitamin B deficiencies\n" +
                            "Helps in formation of red blood cells\n" +
                            "Maintains healthy nervous system",
                    "It promotes health as well as skin benefit.\n" +
                            "It helps reduce skin blemish and pigmentation.\n" +
                            "It acts as safeguard the skin from the harsh UVA & UVB sun rays.",
                    "Dolo 360 tablet helps relieve pain and fever by blocking the release the certain chemical massengers responsible for fever and pain.",
                    "Helps relieve fever and bring down a high temparature\n" +
                            "Suitable for people with a heart condition or high blood pressure",
                    "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n" +
                            "Provides a warm and comforting feeling during sore throat",
                    "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n" +
                            "Promotes mobility and flexibility of joints",
                    "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
            };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCard = findViewById(R.id.buttonBMGoToCard);

        btnGoToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}