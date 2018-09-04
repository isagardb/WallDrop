package in.dropcodes.walldrop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private String previewURL,userImageURL,user,largeImageURL,imageWidth,imageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent bundle = getIntent();
        previewURL = bundle.getStringExtra("previewURL");
        userImageURL = bundle.getStringExtra("userImageURL");
        user = bundle.getStringExtra("user");
        largeImageURL = bundle.getStringExtra("largeImageURL");
        imageWidth = bundle.getStringExtra("imageWidth");
        imageHeight = bundle.getStringExtra("imageHeight");


    }
}
