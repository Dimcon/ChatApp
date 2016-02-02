package com.cybermelon.chatappmain.adapters;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cybermelon.chatappmain.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daimon on 1/30/2016.
 */
public class ChatListAdapter extends RecyclerView.Adapter {

    List<Message> messages = new ArrayList<Message>();
    static String sUserID;

    public ChatListAdapter(String sUserID) {
        this.sUserID = sUserID;
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("Daimon","As you'd expect, first message from me!","R - O|       |O|       |O  2:14 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
        messages.add(new Message("John","As you'd expect, first message from me!","2:19 pm"));
    }

    @Override
    public long getItemId(int position) {
        return position - 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v;
        RecyclerView.ViewHolder vh;
        if (i==1) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_sent,parent,false);
            vh = new ClientViewHolder(v);
        }
        else {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_recieved,parent,false);
            vh = new RecipientViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        View v;
        TextView tvMessage;
        TextView tvStatus;
        if (getItemViewType(i) == 1) {
            v = ((ClientViewHolder) viewHolder).ClientMessage;
            tvMessage = (TextView)v.findViewById(R.id.tv_sent_text);
            tvStatus = (TextView)v.findViewById(R.id.tv_sent_time);
        } else {
            v = ((RecipientViewHolder) viewHolder).RecipientMessage;
            tvMessage = (TextView)v.findViewById(R.id.tv_recieved_text);
            tvStatus = (TextView)v.findViewById(R.id.tv_recieved_time);
        }
        tvMessage.setText(messages.get(i).sText);
        tvStatus.setText(messages.get(i).sTime);
    }

    @Override
    public int getItemViewType(int position) {
        if (messages.get(position).sFrom.equals(sUserID)) return 1;
        else return 0;
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class RecipientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View RecipientMessage;
        public RecipientViewHolder(View Recipient) {
            super(Recipient);
            RecipientMessage = Recipient;
        }

        @Override
        public void onClick(View v) {
            //  Update the array on each click so the data can be reflected when check box items are reborn
        }
    }

    class ClientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View ClientMessage;
        public ClientViewHolder(View Client) {
            super(Client);
            ClientMessage = Client;
        }

        @Override
        public void onClick(View v) {
            //  Update the array on each click so the data can be reflected when check box items are reborn
        }
    }
}

class Message {
    String sType;
    String sText;
    int iSendPhase;
    Bitmap img;
    String sData;
    String sFrom;
    String sTime;

    public Message(String sFrom, String sText,String sTime) {
        this.sFrom = sFrom;
        this.sText = sText;
        this.sTime = sTime;
    }

    public void BuildView(View v) {

    }
}
