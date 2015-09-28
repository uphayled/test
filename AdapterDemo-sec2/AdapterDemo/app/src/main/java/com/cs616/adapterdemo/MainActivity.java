package com.cs616.adapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data set
        final List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(123, "Foo", "555-5555"));
        contacts.add(new Contact(345, "Bar", "555-6666"));
        contacts.add(new Contact(678, "Tar", "555-7777"));

        // create adapter
        /*ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(this,
                                           R.layout.list_row_contact,
                                           R.id.contactTextView_Main,
                                           contacts);
        */
        ContactsArrayAdapter adapter = new ContactsArrayAdapter(this, contacts);


        // list view
        ListView contactsListView = (ListView) this.findViewById(R.id.contactsListView);
        contactsListView.setAdapter(adapter);

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //myItemClick(contacts.get(position).toString());
                Toast.makeText(MainActivity.this, "POS == " + String.valueOf(position) + " ID == " + String.valueOf(id), Toast.LENGTH_SHORT).show();
            }

        });

        contactsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "LONG: " + contacts.get(position).toString(), Toast.LENGTH_SHORT).show();

                return true;
            }
        });



    }

    public void myItemClick(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
