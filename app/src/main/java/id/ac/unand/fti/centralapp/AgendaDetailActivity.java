package id.ac.unand.fti.centralapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AgendaDetailActivity extends AppCompatActivity {

    String namaAgenda;
    TextView textNamaAgendaDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_detail);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            namaAgenda = detailIntent.getStringExtra("NAMA_AGENDA");
            textNamaAgendaDetail = findViewById(R.id.textNamaAgendaDetail);
            textNamaAgendaDetail.setText(namaAgenda);
        }
    }
}