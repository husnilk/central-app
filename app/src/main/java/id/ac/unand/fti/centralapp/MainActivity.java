package id.ac.unand.fti.centralapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;

import id.ac.unand.fti.centralapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

import id.ac.unand.fti.centralapp.adapters.AgendaAdapter;
import id.ac.unand.fti.centralapp.models.Agenda;

public class MainActivity extends AppCompatActivity implements AgendaAdapter.ItemAgendaClickListener {

    private RecyclerView rvAgenda;

    private boolean isLoggedIn = false;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAgenda = findViewById(R.id.rv_agenda);

        AgendaAdapter adapter = new AgendaAdapter(getAgenda());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvAgenda.setLayoutManager(layoutManager);
        rvAgenda.setAdapter(adapter);
    }

    public ArrayList<Agenda> getAgenda(){
        ArrayList<Agenda> listAgenda = new ArrayList<>();
        listAgenda.add(new Agenda(
                null,
                1,
                "Kuliah Pemrograman Teknologi Bergerak",
                "12:00 - 15:00",
                "H2.4",
                1
        ));
        listAgenda.add(new Agenda(
                null,
                1,
                "Kuliah Inovasi Sistem Informasi",
                "12:00 - 15:00",
                "H2.4",
                1
        ));
        listAgenda.add(new Agenda(
                null,
                1,
                "Kuliah Pemrograman Teknologi Bergerak",
                "12:00 - 15:00",
                "H2.4",
                1
        ));
        listAgenda.add(new Agenda(
                null,
                1,
                "Kuliah Inovasi Sistem Informasi",
                "12:00 - 15:00",
                "H2.4",
                1
        ));
        listAgenda.add(new Agenda(
                null,
                1,
                "Kuliah Pemrograman Teknologi Bergerak",
                "12:00 - 15:00",
                "H2.4",
                1
        ));
        listAgenda.add(new Agenda(
                null,
                1,
                "Kuliah Inovasi Sistem Informasi",
                "12:00 - 15:00",
                "H2.4",
                1
        ));
        listAgenda.add(new Agenda(
                null,
                1,
                "Kuliah Pemrograman Teknologi Bergerak",
                "12:00 - 15:00",
                "H2.4",
                1
        ));
        listAgenda.add(new Agenda(
                null,
                1,
                "Kuliah Inovasi Sistem Informasi",
                "12:00 - 15:00",
                "H2.4",
                1
        ));
        return listAgenda;
    }

    @Override
    public void onItemAgendaClick(Agenda agenda) {
        Intent detailIntent = new Intent(this, AgendaDetailActivity.class);
        detailIntent.putExtra("NAMA_AGENDA", agenda.getNamaAgenda());
        startActivity(detailIntent);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("USERNAME");
        isLoggedIn = mainIntent.getBooleanExtra("IS_LOGGED_IN", false);

        if(!isLoggedIn){
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }

        binding.textGreeting.setText("Hello, " + username);

    }
}