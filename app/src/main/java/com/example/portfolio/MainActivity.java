package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView facebook, instagram, twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        //Assign Variable
        facebook = findViewById(R.id.fb);
        instagram = findViewById(R.id.ig);
        twitter = findViewById(R.id.tw);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize
                String sAppLink = "fb://profile/GhaziJaffri";
                String sPackage = "com.facebook.katana";
                String sWebLink = "https://www.facebook.com/GhaziJaffri";
                //Create Method
                openLink(sAppLink, sPackage,sWebLink);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize
                String sAppLink = "https://www.instagram.com/smghazijaffri/";
                String sPackage = "com.instagram.android";
                String sWebLink = "https://www.instagram.com/smghazijaffri/";
                //Call Method
                openLink(sAppLink, sPackage,sWebLink);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize
                String sAppLink = "twitter://user?screen_name=smghazijaffri";
                String sPackage = "com.twitter.android";
                String sWebLink = "https://twitter.com/smghazijaffri";
                //Call Method
                openLink(sAppLink, sPackage,sWebLink);
            }
        });
    }

    private void openLink(String sAppLink, String sPackage, String sWebLink) {
        //Use try catch
        try {
            //When app is installed
            //Initialize uri
            Uri uri = Uri.parse(sAppLink);
            //Initialize
            Intent intent = new Intent((Intent.ACTION_VIEW));
            //Set Data
            intent.setData(uri);
            //Set Package
            intent.setPackage(sPackage);
            //Set Flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start Activity
            startActivity(intent);
        }
        catch (ActivityNotFoundException activityNotFoundException){
            //Open Link in Browser
            Uri uri = Uri.parse(sWebLink);
            //Initialize intent
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //Set Data
            intent.setData((uri));
            //Set Flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start Activity
            startActivity(intent);
        }
    }
}