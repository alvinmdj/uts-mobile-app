package id.ac.umn.alvinmartindjong_00000035733_if570_bl_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText loginName;
    private Button btnLogin;

    private static final int REQUEST_CODE_MAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        loginName = findViewById(R.id.login_name);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(view -> {
            String name = loginName.getText().toString();
            if(!name.trim().isEmpty()) {
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                mainIntent.putExtra("LoginName", name);
                startActivityForResult(mainIntent, REQUEST_CODE_MAIN);
            } else {
                Toast.makeText(this, "Anda belum mengisi nama", Toast.LENGTH_SHORT).show();
                loginName.setError("Harap mengisi nama");
            }
        });
    }
}