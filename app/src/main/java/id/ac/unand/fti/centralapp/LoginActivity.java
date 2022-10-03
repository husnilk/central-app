package id.ac.unand.fti.centralapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import id.ac.unand.fti.centralapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void onButtonLoginClicked(View view) {
        //Explicit Intent
        String username = binding.editUsername.getText().toString();
        String password = binding.edtPassword.getText().toString();

        if(password.equals("123")){
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("USERNAME", username);
            mainIntent.putExtra("IS_LOGGED_IN", true);
            startActivity(mainIntent);
        }else{
            Toast.makeText(this, "Kombinasi username dan password salah", Toast.LENGTH_SHORT).show();
        }
    }

    public void onForgotPasswordClicked(View view) {
        //Implicit Intent
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_SEND);
        callIntent.setType("text/plain");
        callIntent.putExtra(Intent.EXTRA_TEXT, "Halo saya lupa password");
        if(callIntent.resolveActivity(getPackageManager()) != null){
            startActivity(callIntent);
        }else{
            Toast.makeText(this, "Activity tidak tersedia", Toast.LENGTH_SHORT).show();
        }
    }
}