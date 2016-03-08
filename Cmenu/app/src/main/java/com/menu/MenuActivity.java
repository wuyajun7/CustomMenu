package com.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends Activity {

    SliderView sliderView;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        sliderView = (SliderView) findViewById(R.id.slider_view);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderView.setSlided(!sliderView.isSlided());
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                sliderView.setSlided(!sliderView.isSlided());
                Toast.makeText(MenuActivity.this, "asdf", Toast.LENGTH_SHORT).show();
            }
        });
//        listView = (ListView) findViewById(R.id.listView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, new String[]{"GOOD",
//                "HAHA", "What is that?", "FUUUUCK"});
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (!sliderView.isSlided()) {
//                    sliderView.setSlided(true);
//                }
//            }
//        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        return true;
//    }
//
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        sliderView.setSlided(!sliderView.isSlided());
//        return true;
//    }

//    @Override
//    public void onClick(View v) {
//        Toast.makeText(this, ((Button) v).getText().toString(),
//                Toast.LENGTH_LONG).show();
//        sliderView.setSlided(!sliderView.isSlided());
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//        String string = (String) arg0.getItemAtPosition(arg2);
//        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
//    }
}