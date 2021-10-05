package id.ac.umn.alvinmartindjong_00000035733_if570_bl_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    private TextView sfxTitle;
    private TextView sfxDescription;
    private Button btnPlaySFX;
    private String sfxUri;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        sfxTitle = findViewById(R.id.playing_sfx_title);
        sfxDescription = findViewById(R.id.playing_sfx_desc);
        btnPlaySFX = findViewById(R.id.btn_play);

        Intent playIntent = getIntent();
        Bundle bundle = playIntent.getExtras();
        SfxSource sfxSource = (SfxSource) bundle.getSerializable("PlaySFX");
        sfxTitle.setText(sfxSource.getTitle());
        sfxDescription.setText(sfxSource.getDescription());
        sfxUri = sfxSource.getUri();
        setTitle(sfxSource.getTitle());

        mediaPlayer = MediaPlayer.create(this, Uri.parse(sfxUri));

        btnPlaySFX.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                btnPlaySFX.setText(R.string.btn_play);
            } else {
                mediaPlayer.start();
                btnPlaySFX.setText(R.string.btn_pause);

                // set button text to Play SFX after the SFX stopped
                int remainingDuration = mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition();
                new android.os.Handler(Looper.getMainLooper()).postDelayed(
                        () -> btnPlaySFX.setText(R.string.btn_play),
                        remainingDuration
                );
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}