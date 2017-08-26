package com.jorger9.platzigram.post.view;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.storage.StorageReference;
import com.jorger9.platzigram.PlatzigramApplication;
import com.jorger9.platzigram.R;
import com.jorger9.platzigram.model.Picture;
import com.squareup.picasso.Picasso;

public class PictureDetailActivity extends AppCompatActivity {

    private Picture picture;
    private ImageView imageHeader;
    private PlatzigramApplication app;
    private StorageReference storageReference;
    private String PHOTO_NAME = "JPEG_20170712_17-36-57_1922906634.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        app = (PlatzigramApplication) getApplicationContext();
        storageReference = app.getStorageReference();

        imageHeader = (ImageView) findViewById(R.id.imageHeader);

        Intent intent = getIntent();

        picture = new  Picture(intent.getStringExtra("picture"),
                intent.getStringExtra("userName"),
                intent.getStringExtra("time"),
                intent.getStringExtra("likeNumber"));


       // setDetails(picture);
        showToolbar("",true);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setEnterTransition(new Fade());
        }
        
        showData();
    }

    private void showData() {
        storageReference.child("postImages/"+PHOTO_NAME)
                .getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(PictureDetailActivity.this).load(uri.toString()).into(imageHeader);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PictureDetailActivity.this, "Ocurrio un error al cargar la foto", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                FirebaseCrash.report(e);
            }
        });
    }


    public void setDetails(Picture picture)
    {
        //ImageView imageView  = (ImageView)findViewById(R.id.imageHeader);
        TextView  userName   = (TextView)findViewById(R.id.userNameDetail);
        TextView  likeNumber   = (TextView)findViewById(R.id.likeNumberDetail);
        TextView  time   = (TextView)findViewById(R.id.secondWordDetail);



        userName.setText(picture.getUserName());
        likeNumber.setText(picture.getLikeNumber());
        time.setText(picture.getTime());
        //Picasso.with(this).load(picture.getPicture()).into(imageView);
    }

    public void showToolbar(String title, boolean upButton){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }
}
