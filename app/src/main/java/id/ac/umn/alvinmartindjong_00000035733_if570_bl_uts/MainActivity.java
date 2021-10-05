package id.ac.umn.alvinmartindjong_00000035733_if570_bl_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvSfxList;
    SfxListAdapter mAdapter;
    LinkedList<SfxSource> sfxList = new LinkedList<>();
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mainIntent = getIntent();
        if (mainIntent.hasExtra("LoginName")) {
            name = mainIntent.getStringExtra("LoginName");
            Toast.makeText(this, "Selamat datang, " + name, Toast.LENGTH_LONG).show();
            setTitle(name);
        }

        sfxContent();
        rvSfxList = findViewById(R.id.recyclerView);
        mAdapter = new SfxListAdapter(this, sfxList);
        rvSfxList.setAdapter(mAdapter);
        rvSfxList.setLayoutManager(new LinearLayoutManager(this));
    }

    public void sfxContent() {
        sfxList.add(new SfxSource("Applause", "Small group cheer and applause",
                "android.resource://" + getPackageName() + "/" + R.raw.applause));
        sfxList.add(new SfxSource("Bird Cuit-Cuit", "Little birds singing in the trees",
                "android.resource://" + getPackageName() + "/" + R.raw.bird));
        sfxList.add(new SfxSource("Geese Petok", "Flock of wild geese",
                "android.resource://" + getPackageName() + "/" + R.raw.geese));
        sfxList.add(new SfxSource("Laugh", "Crowd laugh together stronger",
                "android.resource://" + getPackageName() + "/" + R.raw.laugh));
        sfxList.add(new SfxSource("Bleeps", "Clock countdown bleeps",
                "android.resource://" + getPackageName() + "/" + R.raw.countdown));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu:
                Intent mainMenuIntent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(mainMenuIntent);
                break;
            case R.id.profile:
                Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
                break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }
}