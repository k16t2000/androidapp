package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Activity4 extends AppCompatActivity {
    Button btn_mus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        VideoView v=findViewById(R.id.video_view);
        //create a path to video file
        String videoPath="android.resource://" + getPackageName() + "/" + R.raw.mm;
        Uri u= Uri.parse(videoPath);
        v.setVideoURI(u);

        //controll buttons
        MediaController m=new MediaController(this);
        v.setMediaController(m);
        m.setAnchorView(v);

        gonext();
    }
    //button go to the next page
    public void gonext(){
        btn_mus=(Button)findViewById(R.id.btn_music);
        btn_mus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(Activity4.this,Activity5.class);
                startActivity(b);//activation activity
            }
        });
    }
}