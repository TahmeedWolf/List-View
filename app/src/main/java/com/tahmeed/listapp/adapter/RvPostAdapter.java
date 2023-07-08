package com.tahmeed.listapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tahmeed.listapp.R;
import com.tahmeed.listapp.model.Posts;

import java.util.List;

public class RvPostAdapter extends RecyclerView.Adapter<RvPostAdapter.MyViewHolder> {

    private List<Posts> recyclerListPost;
    private Context context;


    public RvPostAdapter(Context context, List<Posts> postList) {

        this.recyclerListPost = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvPostAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_view, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvPostAdapter.MyViewHolder holder, int position) {

        holder.txvId.setText("Id: "+recyclerListPost.get(position).getId()+"");
        holder.txvUserId.setText("user Id: "+recyclerListPost.get(position).getUserId()+"");
        holder.txvTitle.setText("Title : "+recyclerListPost.get(position).getTitle());
        holder.txvBody.setText("Body : "+recyclerListPost.get(position).getBody());
    }

    @Override
    public int getItemCount() {

        return recyclerListPost.size();
    }

  static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txvId,txvUserId,txvTitle,txvBody;

        public MyViewHolder(View itemView) {
            super(itemView);

            txvId = itemView.findViewById(R.id.post_id);
            txvUserId = itemView.findViewById(R.id.post_userId);
            txvTitle = itemView.findViewById(R.id.post_title);
            txvBody = itemView.findViewById(R.id.post_body);

        }
    }
}
