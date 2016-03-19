package de.tc_schoenningstedt.tcs;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterAdapter extends RecyclerView.Adapter<AdapterAdapter.MyViewHolder> {

    private List<Adapter> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, telefon, email;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            telefon = (TextView) view.findViewById(R.id.telefon);
            email = (TextView) view.findViewById(R.id.email);
        }
    }


    public AdapterAdapter(List<Adapter> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Adapter movie = moviesList.get(position);
        holder.name.setText(movie.getTitle());
        holder.telefon.setText(movie.getGenre());
        holder.email.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}