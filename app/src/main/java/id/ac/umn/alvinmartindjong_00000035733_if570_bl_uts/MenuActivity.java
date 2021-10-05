package id.ac.umn.alvinmartindjong_00000035733_if570_bl_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button btnProfile, btnLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnProfile = findViewById(R.id.btn_profile);
        btnLibrary = findViewById(R.id.btn_library);

        btnProfile.setOnClickListener(view -> {
            Intent profileIntent = new Intent(MenuActivity.this, ProfileActivity.class);
            startActivity(profileIntent);
        });

        btnLibrary.setOnClickListener(view -> {
            Intent loginIntent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });
    }
}