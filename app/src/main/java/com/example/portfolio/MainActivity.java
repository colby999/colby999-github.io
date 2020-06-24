package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String myurl="file:///android_asset/index.html";
        WebView view =(WebView) this.findViewById(R.id.webView);
        view.getSettings() .setJavaScriptEnabled(true);
        view.loadUrl(myurl);
    }

    public void play(View v){
        if (player == null){
            player = MediaPlayer.create(this, R.raw.aud);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopplayer();
                }
            });
        }
        player.start();
    }

    public void pause(View v){
        if (player != null){
            player.pause();
        }
    }

    public void stop(View v){
stopplayer();
    }
private void stopplayer(){
        if (player!= null){
            player.release();
            player = null;
            Toast.makeText(this, "MeadiaPlayer Released", Toast.LENGTH_SHORT).show();
        }
}

    @Override
    protected void onStop() {
        super.onStop();
        stopplayer();
    }
}




 