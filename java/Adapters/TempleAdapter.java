package Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.onlineshop.marpar.marpar.R;
import com.onlineshop.marpar.marpar.veghotelonclick;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import Models.TempleModel;

/**
 * Created by Mgr studio on 26/12/2018.
 */

public class TempleAdapter extends RecyclerView.Adapter<TempleAdapter.viewHolder> {

  private List<TempleModel>list;
    View  view;
    public TempleAdapter(List<TempleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    Context context;
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         view= LayoutInflater.from(parent.getContext()).inflate(R.layout.templexml,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, final int position) {

      TempleModel model=list.get(position);

        Picasso.get().load(model.getImageUrl()).fit().into(holder.imageView, new Callback() {
            @Override
            public void onSuccess() {
            holder.avi.smoothToHide();

            }

            @Override
            public void onError(Exception e) {

            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veghotelonclick veghotelonclick=new veghotelonclick();
                Bundle bundle=new Bundle();

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                //   Fragment myFragment = new veghotelonclick();

                bundle.putString("name",list.get(position).getTempleName());
                bundle.putString("desc",list.get(position).getDescription());
                bundle.putDouble("lat",list.get(position).getLat());
                bundle.putDouble("lan",list.get(position).getLon());
                veghotelonclick.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment,veghotelonclick).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
     ImageView imageView;
        LinearLayout layout;
        AVLoadingIndicatorView avi;

        public viewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.TempleImage);
            layout=(LinearLayout)itemView.findViewById(R.id.TempleImageclick);
            avi=(AVLoadingIndicatorView)itemView.findViewById(R.id.avi);


        }
    }
}
