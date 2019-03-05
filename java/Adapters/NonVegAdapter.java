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

import Models.NonVegHotelModel;

/**
 * Created by Mgr studio on 27/12/2018.
 */

public class NonVegAdapter extends RecyclerView.Adapter<NonVegAdapter.viewHolder> {
    public NonVegAdapter(List<NonVegHotelModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    List<NonVegHotelModel> list;
    Context context;
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.nonveghotelxml,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, final int position) {
        NonVegHotelModel model=list.get(position);
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

                bundle.putString("name",list.get(position).getHotelName());
                bundle.putString("desc",list.get(position).getDesc());
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
            imageView=(ImageView)itemView.findViewById(R.id.nonvegImage);
            layout=(LinearLayout)itemView.findViewById(R.id.nonvegClick);
            avi=(AVLoadingIndicatorView)itemView.findViewById(R.id.avi);
        }

    }
}
