package aldian.com.soundbox;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static aldian.com.soundbox.MainActivity.mediaPlayer;

public class CandySongActivity extends MainActivity implements View.OnClickListener{
    private Button playButton;
    private Button nextButton;
    private Button prevButton;
    private TextView text;
    private Button goToLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candy_song);

        //media player
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.robbie_williams_candy);

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
                Intent intent = new Intent(CandySongActivity.this, SongSelector.class);
                startActivity(intent);
        }

    }

    public void playMusic(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            text.setText("Robby Williams - Candy is playing.");
            playButton.setBackground(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }

    public void pauseMusic(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            text.setText("Robby Williams - Candy is paused..");
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
