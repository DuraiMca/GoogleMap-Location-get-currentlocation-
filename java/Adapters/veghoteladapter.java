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

import Models.vegHotelModel;

/**
 * Created by Mgr studio on 24/12/2018.
 */

public class veghoteladapter extends RecyclerView.Adapter<veghoteladapter.viewholder> {


  private   List<vegHotelModel> list;

    public veghoteladapter(List<vegHotelModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private Context context;




    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.veghotelxml,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(final viewholder holder, final int position) {
     vegHotelModel hotelModel=list.get(position);

        Picasso.get()
                .load(hotelModel.getImgurl())

               .fit()
                .into(holder.imageView, new Callback() {
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
               bundle.putDouble("lan",list.get(position).getLan());
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
     //   TextView textView;
        LinearLayout layout;
        AVLoadingIndicatorView avi;
        public viewholder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.veghotelpic);

         //   textView=itemView.findViewById(R.id.veghotelname);
            layout=itemView.findViewById(R.id.vegLinear);
            avi=(AVLoadingIndicatorView)itemView.findViewById(R.id.avi);
        }
    }
}
