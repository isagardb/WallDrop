package in.dropcodes.walldrop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import in.dropcodes.walldrop.Adapter.MainAdapter;
import in.dropcodes.walldrop.Model.MainModel;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView mRecyclerView;
    private MainAdapter adapter;
    private ArrayList<MainModel> mainModels;
    private RequestQueue requestQueue;
    private String URL = "https://pixabay.com/api/?key=9910517-7462ed0a9b57cffbe5dcdb6ae&per_page=200";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mainModels = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        getData();
    }

    private void getData() {

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length() ; i++){

                                JSONObject hits = jsonArray.getJSONObject(i);

                                String PreViewImage = hits.getString("previewURL");
                                String userImage = hits.getString("userImageURL");
                                String userName = hits.getString("user");
                                String largeImageURL = hits.getString("largeImageURL");
                                int imageWidth = hits.getInt("imageWidth");
                                int imageHeight = hits.getInt("imageHeight");

                                mainModels.add(new MainModel(PreViewImage,userImage,userName,largeImageURL,imageWidth,imageHeight));
                            }

                            adapter = new MainAdapter(MainActivity.this,mainModels);
                            mRecyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(request);
    }

      /*  Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        MainModel m = mainModels.get(position);
        intent.putExtra("previewURL",m.getPreviewURL());
        intent.putExtra("userImageURL",m.getUserImageURL());
        intent.putExtra("user",m.getUser());
        intent.putExtra("largeImageURL",m.getLargeImageURL());
        intent.putExtra("imageWidth",m.getImageWidth());
        intent.putExtra("imageHeight",m.getImageHeight());
        startActivity(intent);  */
    }

