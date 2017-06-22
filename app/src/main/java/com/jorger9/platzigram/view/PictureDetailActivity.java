package com.jorger9.platzigram.view;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorger9.platzigram.R;
import com.jorger9.platzigram.model.Picture;
import com.squareup.picasso.Picasso;

public class PictureDetailActivity extends AppCompatActivity {

    private Picture picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        Intent intent = getIntent();

        picture = new  Picture(intent.getStringExtra("picture"),
                intent.getStringExtra("userName"),
                intent.getStringExtra("time"),
                intent.getStringExtra("likeNumber"));


        setDetails(picture);
        showToolbar("",true);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setEnterTransition(new Fade());
        }
    }


    public void setDetails(Picture picture)
    {
        ImageView imageView  = (ImageView)findViewById(R.id.imageHeader);
        TextView  userName   = (TextView)findViewById(R.id.userNameDetail);
        TextView  likeNumber   = (TextView)findViewById(R.id.likeNumberDetail);
        TextView  time   = (TextView)findViewById(R.id.secondWordDetail);



        userName.setText(picture.getUserName());
        likeNumber.setText(picture.getLikeNumber());
        time.setText(picture.getTime());
        Picasso.with(this).load(picture.getPicture()).into(imageView);
    }

    public void showToolbar(String title, boolean upButton){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }
}
