package aldian.com.soundbox;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class SongSelector extends MainActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_selector);

        listView = (ListView)findViewById(R.id.listViewId);

        final String[] songList = new String[]{
                "Mia and Sebastian's Song",
                "City of Stars",
                "Robbie Williams - Candy",
                "Photograph"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, songList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int songPosition = position;
                if(songPosition == 0){
                    //trying to set so if you click the music that is playing is cut off, but the
                    //code below doesn't seem to work
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                    mediaPlayer = null;
                    Intent intent = new Intent(SongSelector.this, MainActivity.class);
                    //wanna try so that if the song is selected it will come on automatically.
                    intent.putExtra("Key", "Play");
                    startActivity(intent);
                } else if (songPosition == 2) {
                    Intent intent = new Intent(SongSelector.this, CandySongActivity.class);
                    //same here
                    intent.putExtra("Key", "Play");
                    startActivity(intent);
                }
            }
        });


    }
}
