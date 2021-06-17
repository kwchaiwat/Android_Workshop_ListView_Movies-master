package com.example.listviewworkshop;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //List of movies
    String[] Movies = new String[]{
            "Birds of Prey ทีมนกผู้ล่า กับ ฮาร์ลีย์ ควินน์ ผู้เริดเชิด", "Classic Again จดหมาย สายฝน ร่มวิเศษ", "Bombshell แฉกระฉ่อนโลก", "1917 หนึ่งเก้าหนึ่งเจ็ด",
            "The Gentlemen สุภาพบุรุษมาหากัญ", "Secret Zoo เฟคซูสู้เว้ย", "Low Season สุขสันต์วันโสด", "Judy จูดี้ การ์แลนด์"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Do your code here
        final ListView listViewMovie = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Movies);
        listViewMovie.setAdapter(adapter);

        listViewMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemValue = (String) listViewMovie.getItemAtPosition(i);
                Intent showPage = new Intent(MainActivity.this, Main2Activity.class);
                showPage.putExtra("id", "" + i + "");
                showPage.putExtra("title", "" + itemValue + "");
                startActivity(showPage);
            }
        });
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
