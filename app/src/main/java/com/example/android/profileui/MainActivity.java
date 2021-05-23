package com.example.android.profileui;

import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isOpen = false;
    private ConstraintSet layout1;
    private ConstraintSet layout2;
    private ConstraintLayout constraintLayout;
    private ImageView picture;
    private TextView github;
    private TextView playstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        layout1 = new ConstraintSet();
        layout2 = new ConstraintSet();

        constraintLayout = findViewById(R.id.layout);
        picture = findViewById(R.id.picture);

        layout1.clone(constraintLayout);
        layout2.clone(this, R.layout.expanded_profile);

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpen){
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    layout2.applyTo(constraintLayout);
                    isOpen = !isOpen;
                }else{
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    layout1.applyTo(constraintLayout);
                    isOpen = !isOpen;
                }
            }
        });


        github = findViewById(R.id.git_hub);
        playstore = findViewById(R.id.tv_google_play);

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/noemibalazs?tab=repositories"));
                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }

            }
        });

        playstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Bal%C3%A1zs+No%C3%A9mi"));
                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
            }
        });


    }
}
