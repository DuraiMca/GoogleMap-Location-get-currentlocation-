package Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.onlineshop.marpar.marpar.R;
import com.onlineshop.marpar.marpar.veghotelonclick;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import Models.TouristModel;

/**
 * Created by Mgr studio on 27/12/2018.
 */

public class TouristAdapter extends RecyclerView.Adapter<TouristAdapter.viewholder> {
    List<TouristModel>list;

    public TouristAdapter(List<TouristModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    Context context;
    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.touristxml,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(final viewholder holder, final int position) {
        TouristModel model=list.get(position);
        Picasso.get().load(model.getUrl()).fit().into(holder.imageView, new Callback() {
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

                bundle.putString("name",list.get(position).getPlace());
                bundle.putString("desc",list.get(position).getDescription());
                bundle.putDouble("lat",list.get(position).getLat());
                bundle.putDouble("lan",list.get(position).getLon());
                veghotelonclick.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment, veghotelonclick).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        LinearLayout layout;
        AVLoadingIndicatorView avi;
        public viewholder(View itemView) {

            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.TouristImage);
            layout=(LinearLayout)itemView.findViewById(R.id.TouristClick);
            avi=(AVLoadingIndicatorView)itemView.findViewById(R.id.avi);
        }
    }
}
