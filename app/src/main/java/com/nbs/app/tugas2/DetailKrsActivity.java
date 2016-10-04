package com.nbs.app.tugas2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class DetailKrsActivity extends AppCompatActivity {

    private TextView tv_detail_krs;
    private String detail_krs;
    private Button btn_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_krs);

        tv_detail_krs = (TextView) findViewById(R.id.tv_detail_krs);
        btn_kembali = (Button) findViewById(R.id.btn_kembali);
        final Bundle krsArrayList = getIntent().getExtras();

        ArrayList<String> krsArray = krsArrayList.getStringArrayList("KRS");
        detail_krs="";
        for (int i=0; i<krsArray.size(); i++){
            detail_krs += krsArray.get(i)+ "\n";
        }

        tv_detail_krs.setText(detail_krs);
        btn_kembali.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
