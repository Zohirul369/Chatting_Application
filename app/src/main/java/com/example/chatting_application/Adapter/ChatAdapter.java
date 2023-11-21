package com.example.chatting_application.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatting_application.Model.Messages;
import com.example.chatting_application.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SimpleTimeZone;

public class ChatAdapter extends RecyclerView.Adapter{
    ArrayList<Messages> messageModels;
    Context context;
    String recId;

    int SENDER_VIEW_TYPE = 1;
    int RECEIVER_VIEW_TYPE = 2;


    public ChatAdapter(ArrayList<Messages> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    public ChatAdapter(ArrayList<Messages> messageModels, Context context, String recId) {
        this.messageModels = messageModels;
        this.context = context;
        this.recId = recId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SENDER_VIEW_TYPE)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_sender,parent,false);
            return new SenderViewHolder(view);
        }
        else
        {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_receiver,parent,false);
            return  new ReceiverViewHolder(view);

        }
    }


    @Override
    public int getItemViewType(int position) {

        if (messageModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid()))
        {
            return SENDER_VIEW_TYPE;
        }
        else
        {
            return RECEIVER_VIEW_TYPE;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Messages messages = messageModels.get(position);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete")
                        .setMessage("Are you sure you want to delete this messages?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                String sennderRoom = FirebaseAuth.getInstance().getUid()  + recId;
                                database.getReference().child("chats").child(sennderRoom)
                                        .child(messages.getMessageId())
                                        .setValue(null);

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();

                return false;
            }
        });

        if (holder.getClass() == SenderViewHolder.class )
        {
            ((SenderViewHolder)holder).senderMgs.setText(messages.getMessage());

        }
        else
        {
            ((ReceiverViewHolder)holder).receiverMgs.setText(messages.getMessage());
        }


    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public class ReceiverViewHolder extends RecyclerView.ViewHolder{
        TextView receiverMgs, receiverTime;
        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);
            receiverMgs = itemView.findViewById(R.id.receiver_chat_mgs);
            receiverTime = itemView.findViewById(R.id.receiver_time_view);

        }

    }

    public class SenderViewHolder extends RecyclerView.ViewHolder{

        TextView senderMgs, senderTime;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
            senderMgs = itemView.findViewById(R.id.sender_chat_mgs);
            senderTime = itemView.findViewById(R.id.sender_time_view);

        }
    }
}
