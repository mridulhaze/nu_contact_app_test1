package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import  android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mridul.myapplication.Model.Friend;
import com.example.mridul.myapplication.R;

import java.util.List;

/**
 * Created by mridul on 6/2/2018.
 */



class SearchViewHolder extends  RecyclerView.ViewHolder{

    public TextView name,address,email,phone;

    public SearchViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.name);
        address = (TextView)itemView.findViewById(R.id.address);
        email = (TextView)itemView.findViewById(R.id.email);
        phone = (TextView)itemView.findViewById(R.id.phone);
    }
}



public class SearchAdapter extends  RecyclerView.Adapter<SearchViewHolder>{

    private Context context;
    private List<Friend> friends ;

    public SearchAdapter(Context context,List<Friend> friends) {
        this.context = context;
        this.friends = friends;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item,parent,false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.name.setText(friends.get(position).getName());
        holder.address.setText(friends.get(position).getAddress());
        holder.email.setText(friends.get(position).getEmail());
        holder.phone.setText(friends.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return friends.size();
    }
}
