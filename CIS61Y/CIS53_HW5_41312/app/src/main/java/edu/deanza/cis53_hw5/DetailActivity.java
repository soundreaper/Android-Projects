package edu.deanza.cis53_hw5;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private String dayWeather;
    private TextView textViewDetail;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewDetail = (TextView) findViewById(R.id.textViewDetail);

        Intent intentFromMainFragment = getIntent();

        if(intentFromMainFragment != null){
            if(intentFromMainFragment.hasExtra(Intent.EXTRA_TEXT)){
                dayWeather = intentFromMainFragment.getStringExtra(Intent.EXTRA_TEXT);
                textViewDetail.setText(dayWeather);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.detail_menu, menu);

        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_item_share);

        //create intent when shared
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText(dayWeather)
                .getIntent();


     /*   shareIntent.setAction("Intent.ACTION_SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, dayWeather);*/

        item.setIntent(shareIntent);
        Log.d("CIS53", "Share " + dayWeather);
        // Return true to display menu
        return true;
    }

}
