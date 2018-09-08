package in.dropcodes.walldrop.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import in.dropcodes.walldrop.Adapter.AllFragmentAdapter;
import in.dropcodes.walldrop.Model.MainModel;
import in.dropcodes.walldrop.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {


    public AllFragment() {
        // Required empty public constructor
    }

    private RecyclerView mRecyclerView;
    private AllFragmentAdapter adapter;
    private ArrayList<MainModel> mainModels;
    private RequestQueue requestQueue;
    private String URL = "https://pixabay.com/api/?key=9910517-7462ed0a9b57cffbe5dcdb6ae&per_page=200";
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);

                mRecyclerView = view.findViewById(R.id.all_recycler_view);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

                swipeRefreshLayout = view.findViewById(R.id.all_swipRefresh);

                mainModels = new ArrayList<>();

                requestQueue = Volley.newRequestQueue(getContext());
                getData();
                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        getData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        return view;
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

                            adapter = new AllFragmentAdapter(getContext(),mainModels);
                            mRecyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(request);
    }

}
