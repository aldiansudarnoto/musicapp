package aldian.com.soundbox;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button playButton;
    private Button nextButton;
    private Button prevButton;
    public static   MediaPlayer mediaPlayer = new MediaPlayer();
    private TextView text;
    private Button goToLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //media player
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.miasebastianpianosong);

        //button
        playButton = (Button)findViewById(R.id.playButtonId);
        nextButton = (Button)findViewById(R.id.nextButtonId);
        prevButton = (Button)findViewById(R.id.prevButtonId);
        goToLibrary = (Button)findViewById(R.id.goToLibraryButtonId);

        //text
        text = (TextView)findViewById(R.id.artistName);

        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        goToLibrary.setOnClickListener(this);

        // wanna try to get if chosen in the songselector the song will play automatically.
        //the code below doesn't work
//        Bundle bundle = getIntent().getExtras();
//        if(bundle.getString("Key") == "Play"){
//            playMusic();
//        } else {
//
//        }




    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.playButtonId:
                if(mediaPlayer.isPlaying()){
                    pauseMusic();
                } else{
                    playMusic();
                }
                break;
            case R.id.nextButtonId:


                break;
            case R.id.prevButtonId:

                break;
            case R.id.goToLibraryButtonId:
                Intent intent = new Intent(MainActivity.this, SongSelector.class);
                startActivity(intent);
        }

    }

    public void playMusic(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            text.setText("Mia & Sebastian's Theme is playing.");
            playButton.setBackground(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }

    public void pauseMusic(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            text.setText("Mia & Sebastian's Theme is paused..");
            playButton.setBackground(getResources().getDrawable(android.R.drawable.ic_media_play));
        }
    }

    public void prevMusic(){
        if (mediaPlayer != null){
            //do something
        }
    }

    public void nextMusic(){
        if (mediaPlayer != null){
            //do something
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
