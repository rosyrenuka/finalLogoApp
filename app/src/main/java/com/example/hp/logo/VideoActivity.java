package com.example.hp.logo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity {

    TextView text1;
    TextView text2;
    Intent data;

// activity video

    public static final String API_KEY="AIzaSyDLVBdKXGSirHldyUKdSGO55sayavaBs_w";
    public static final String VIDEO_ID="qKX8ncb7Z9g";

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        data=getIntent();

        text1=findViewById(R.id.videotext1);
        text2=findViewById(R.id.videotext2);

        text1.setText("Top Headline India may soon have to deal with a thousand Tuticorins, all up in arms");
        text2.setText("The Ganga has for long been drain flows past  Kanpur, with the drain flows past Bangali Ghat and the ruins of a fort streams diverging near the Green Park cricket" +
                " stadium and then reuniting under and the ruins of a fort before again separating to accommodate Majhara P" +
                "ipar of a fort Unnao District. This summer, " +
                        " and the right bank of the river, drain flows past adjacent to Kanpur, has no water What flows," +
                " instead, is a dark  waste, chromium and sulphide from the tanneries in" +
                " Jajmau area. The discharge drain flows pas a fort tannery drain flows past , to meet the " +
                        "lefthand stream of the Ganga under the bridge.");




        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);


        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("uYmpUa38-Fk");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
//AIzaSyDLVBdKXGSirHldyUKdSGO55sayavaBs_w
        youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
    }
}
