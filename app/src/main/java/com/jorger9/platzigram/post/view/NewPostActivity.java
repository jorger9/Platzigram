package com.jorger9.platzigram.post.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jorger9.platzigram.R;
import com.squareup.picasso.Picasso;

public class NewPostActivity extends AppCompatActivity {

    private ImageView imgPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);

        if(getIntent().getExtras() != null){

            String photoPath = getIntent().getExtras().getString("PHOTO_PATH_TEMP");
            Picasso.with(this).load(photoPath).into(imgPhoto);
        }

    }
}
