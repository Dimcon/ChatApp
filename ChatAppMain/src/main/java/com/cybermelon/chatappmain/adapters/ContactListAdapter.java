package com.cybermelon.chatappmain.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cybermelon.chatappmain.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daimon on 1/24/2016.
 */
public class ContactListAdapter  extends RecyclerView.Adapter{

    List<Contact> contacts = new ArrayList<Contact>();

    public ContactListAdapter() {
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));
        contacts.add(new Contact("Daimon Sewell","0724855478"));

    }

    @Override
    public long getItemId(int position) {
        return position - 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item_layout,parent,false);
        ListItemViewHolder vh = new ListItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        View v = viewHolder.itemView;
        ((ListItemViewHolder) viewHolder ).ID = i;
        if (i==2 || i==0 /*|| i==4 */) {
            v.setPadding(10,300,10,10);
        } else {
            v.setPadding(10,10,10,10);
        }
        TextView tv = (TextView) v.findViewById(R.id.contact_username);
        tv.setText(contacts.get(i).sDisplayName + i);
        TextView tv2 = (TextView) v.findViewById(R.id.contact_number);
        tv2.setText(contacts.get(i).sNumber);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View ListItem;
        int ID;
        public ListItemViewHolder(View itemView) {
            super(itemView);
            ListItem = itemView;
            // Only need the check box to be clickable ->
        }

        @Override
        public void onClick(View v) {
            //  Update the array on each click so the data can be reflected when check box items are reborn
        }
    }
}

class Contact {
    Bitmap bContImage;
    String sDisplayName;
    String sNumber;

    public Contact(String sDisplayNameP, String sNumberP) {
        this.sDisplayName = sDisplayNameP;
        this.sNumber = sNumberP;
    }

    public void BuildView(View v) {

    }
}
