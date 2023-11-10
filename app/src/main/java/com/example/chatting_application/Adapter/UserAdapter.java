package com.example.chatting_application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatting_application.Model.User;
import com.example.chatting_application.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    ArrayList<User> list;
    Context context;

    public UserAdapter(ArrayList<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_users,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User user =list.get(position);
        Picasso.get().load(user.getProfilePic()).placeholder(R.drawable.avatar).into(holder.image);
        holder.userName.setText(user.getUserName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView userName, lastMassage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.profile_pic);
            userName = itemView.findViewById(R.id.user_name_list);
            lastMassage = itemView.findViewById(R.id.last_massage);
        }
    }
}
