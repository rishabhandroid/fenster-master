package com.malmstein.fenster.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MediaPlayerDemoActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo);
        bindViews();
    }

    private void bindViews() {
        findViewById(R.id.start_gesture_media_player_button).setOnClickListener(this);
        findViewById(R.id.start_simple_media_player_button).setOnClickListener(this);
        findViewById(R.id.local_file_media_player_button).setOnClickListener(this);
        findViewById(R.id.start_scale_media_player_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_gesture_media_player_button:
                startActivity(new Intent(this, GestureMediaPlayerActivity.class));
                break;
            case R.id.start_simple_media_player_button:
                startActivity(new Intent(this, SimpleMediaPlayerActivity.class));
                break;
            case R.id.local_file_media_player_button:
                Intent localStream = new Intent(this, SimpleMediaPlayerActivity.class);
                localStream.putExtra(SimpleMediaPlayerActivity.KEY_LOCAL_FILE, true);
                startActivity(localStream);
                break;
            case R.id.start_scale_media_player_button:
                startActivity(new Intent(this, ScaleMediaPlayerActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
