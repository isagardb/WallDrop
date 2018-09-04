package in.dropcodes.walldrop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import in.dropcodes.walldrop.DetailActivity;
import in.dropcodes.walldrop.Model.MainModel;
import in.dropcodes.walldrop.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context mContext;
    private ArrayList<MainModel> mainModels;

    public MainAdapter(Context mContext, ArrayList<MainModel> mainModels) {
        this.mContext = mContext;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_layout,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        final MainModel model = mainModels.get(position);
        holder.mUser.setText(model.getUser());

        Picasso.get().load(model.getPreviewURL()).placeholder(R.drawable.ic_launcher_foreground).fit().centerInside().into(holder.mImage);
        Picasso.get().load(model.getUserImageURL()).placeholder(R.drawable.ic_launcher_foreground).fit().centerInside().into(holder.mUserImage);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(mContext,DetailActivity.class);
                        intent.putExtra("previewURL",model.getPreviewURL());
                        intent.putExtra("userImageURL",model.getUserImageURL());
                        intent.putExtra("user",model.getUser());
                        intent.putExtra("largeImageURL",model.getLargeImageURL());
                        intent.putExtra("imageWidth",model.getImageWidth());
                        intent.putExtra("imageHeight",model.getImageHeight());
                        mContext.startActivity(intent);
                    }
                });thread.start();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImage;
        public TextView mUser;
        public CircleImageView mUserImage;
        public CardView mCardView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.image_view);
            mUser = itemView.findViewById(R.id.user_name);
            mUserImage = itemView.findViewById(R.id.auther_img);
            mCardView = itemView.findViewById(R.id.card_view);

        }
    }
}
