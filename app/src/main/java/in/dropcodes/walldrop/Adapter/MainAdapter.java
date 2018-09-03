package in.dropcodes.walldrop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

import in.dropcodes.walldrop.Model.MainModel;
import in.dropcodes.walldrop.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context mContext;
    private ArrayList<MainModel> mainModels;
    private OnItemClick mListner;

    public interface OnItemClick{
        void onItemClick(int position);
    }

    public void setOnItemClickListner(OnItemClick listner){
        mListner = listner;
    }

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

        MainModel model = mainModels.get(position);
        holder.mUser.setText(model.getUser());

        Picasso.get().load(model.getPreviewURL()).placeholder(R.drawable.ic_launcher_foreground).fit().centerInside().into(holder.mImage);

    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImage;
        public TextView mUser;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.image_view);
            mUser = itemView.findViewById(R.id.user_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListner != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListner.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
