package com.nbs.app.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;

public class KrsActivity extends AppCompatActivity {
    private final String NAMA = "Mohamad Denis Juliansyah";
    private final String NIM = "1137050142";
    private final String ANGKATAN = "2013";
    private TextView txt_nama, txt_nim, txt_angkatan;
    private CheckBox check_mobile_programming, check_rekayasa_perangkat_lunak, check_jaringan_komputer, check_sistem_basis_data, check_pemrograman_internet,
    check_data_mining, check_proyek_perangkat_lunak;
    private Button btn_selanjutnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krs);

        txt_nama = (TextView) findViewById(R.id.tv_nama);
        txt_nim = (TextView) findViewById(R.id.tv_nim);
        txt_angkatan = (TextView) findViewById(R.id.tv_angkatan);
        check_mobile_programming = (CheckBox) findViewById(R.id.cb_mobile_programing);
        check_rekayasa_perangkat_lunak = (CheckBox) findViewById(R.id.cb_rekayasa_perangkat_lunak);
        check_jaringan_komputer = (CheckBox) findViewById(R.id.cb_jaringan_komputer);
        check_sistem_basis_data = (CheckBox) findViewById(R.id.cb_sistem_basis_data);
        check_pemrograman_internet = (CheckBox) findViewById( R.id.cb_pemograman_internet);
        check_data_mining = (CheckBox) findViewById(R.id.cb_data_mining);
        check_proyek_perangkat_lunak = (CheckBox) findViewById(R.id.cb_proyek_perangkat_lunak);
        btn_selanjutnya = (Button) findViewById(R.id.btn_selanjutnya);

        txt_nama.setText(NAMA);
        txt_nim.setText(NIM);
        txt_angkatan.setText(ANGKATAN);

        btn_selanjutnya.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ArrayList<String> myStringArray = new ArrayList<>();
                if(check_mobile_programming.isChecked())myStringArray.add(check_mobile_programming.getText().toString());
                if(check_rekayasa_perangkat_lunak.isChecked())myStringArray.add(check_rekayasa_perangkat_lunak.getText().toString());
                if(check_jaringan_komputer.isChecked())myStringArray.add(check_jaringan_komputer.getText().toString());
                if(check_sistem_basis_data.isChecked())myStringArray.add(check_sistem_basis_data.getText().toString());
                if(check_pemrograman_internet.isChecked())myStringArray.add(check_pemrograman_internet.getText().toString());
                if(check_data_mining.isChecked())myStringArray.add(check_data_mining.getText().toString());
                if(check_proyek_perangkat_lunak.isChecked())myStringArray.add(check_proyek_perangkat_lunak.getText().toString());

                Log.i("myStringArray", myStringArray.toString());
                Intent i = new Intent(KrsActivity.this,DetailKrsActivity.class);
                i.putStringArrayListExtra("KRS", myStringArray);
                startActivity(i);

            }
        });
    }
}
