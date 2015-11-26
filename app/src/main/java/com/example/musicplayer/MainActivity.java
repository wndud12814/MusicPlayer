package com.example.musicplayer;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMplayer;
    private Button bt_start;
    private Button bt_stop;
    private ListView lv_music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMplayer = new MediaPlayer();

        bt_start = (Button)findViewById(R.id.bt_start);
        bt_stop = (Button)findViewById(R.id.bt_stop);

        try {
            AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.boysandgirls_mp3);
            mMplayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        bt_start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                try {
                    mMplayer.prepare();
                    mMplayer.start();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_stop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mMplayer.stop();
            }
        });final String[] musicList = {"Boys and Girls", "No Make Up", "Zeze"};
//        ArrayAdapter<String> musicAdapter;
//        musicAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, musicList);
//        lv_music.setAdapter(musicAdapter);
//        lv_music.setOnClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "clikc :" + musicList[position], Toast.LENGTH_LONG).show();
//            }
//        });

//

//        final String[] musicList = {"Boys and Girls", "No Make Up", "Zeze"};
//        ArrayAdapter<String> musicAdapter;
//        musicAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, musicList);
//        lv_music.setAdapter(musicAdapter);
//        lv_music.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "click : "+ musicList[position], Toast.LENGTH_LONG).show();
//            }
//        });

    }
}
