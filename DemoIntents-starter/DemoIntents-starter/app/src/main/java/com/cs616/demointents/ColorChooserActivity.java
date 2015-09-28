package com.cs616.demointents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;

public class ColorChooserActivity extends Activity {

    private SeekBar redSeekBar;
    private SeekBar blueSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar alphaSeekBar;
    private ImageView colorImageView;
    private RGBAColor currentColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_chooser);

        // init control references
        alphaSeekBar = (SeekBar) findViewById(R.id.alphaSeekBar);
        redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        colorImageView = (ImageView) findViewById(R.id.colorImageView);

        // set seekbar event handler
        SeekBar.OnSeekBarChangeListener seekChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                currentColor = new RGBAColor(
                                redSeekBar.getProgress(),
                                greenSeekBar.getProgress(),
                                blueSeekBar.getProgress(),
                                alphaSeekBar.getProgress()
                            );
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb) {}

            @Override
            public void onStopTrackingTouch(SeekBar sb) {}
        };
        alphaSeekBar.setOnSeekBarChangeListener(seekChangeListener);
        redSeekBar.setOnSeekBarChangeListener(seekChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(seekChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(seekChangeListener);
    }

    private void updateColor() {
        colorImageView.setBackgroundColor(currentColor.asInt());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color_chooser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_ok) {
            // OK should return the new currentColor
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
