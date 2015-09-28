package com.cs616.adapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ian.clement on 2015-09-21.
 */
public class ContactsArrayAdapter extends ArrayAdapter<Contact> {

    public ContactsArrayAdapter(Context context, List<Contact> objects) {
        super(context, -1, objects);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View newRow;

        if(convertView == null) {
            // inflate the new row from the XML layout
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            newRow = inflater.inflate(R.layout.list_row_contact, parent, false);
        }
        else
            newRow = convertView;

        // set the name and phone number
        TextView nameTextView = (TextView) newRow.findViewById(R.id.nameTextView_Contact_List);
        TextView phoneNumTextView = (TextView) newRow.findViewById(R.id.phoneNumTextView_Contact_List);

        Contact contact = getItem(position);
        nameTextView.setText(contact.getName());
        phoneNumTextView.setText(contact.getPhoneNum());

        return newRow;
    }
}



























