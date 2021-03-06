package de.tc_schoenningstedt.tcs;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

public class AdapterTermine extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Termine> data= Collections.emptyList();
    Termine current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterTermine(Context context, List<Termine> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_termine, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        Termine current=data.get(position);
        myHolder.ereignis.setText(current.ereignis);
        myHolder.datum.setText(current.datum);


    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView ereignis;
        TextView datum;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            ereignis= (TextView) itemView.findViewById(R.id.ereignis);
            datum = (TextView) itemView.findViewById(R.id.datum);
        }

    }

}