package com.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends Activity {

    SliderView sliderView;
    ListView listView, listView2;

    NNMenuAdapter adapter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        initData1(0);

        sliderView = (SliderView) findViewById(R.id.slider_view);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sliderView.isSlided()) {
                    sliderView.setSlided(!sliderView.isSlided());
                }
            }
        });
        listView = (ListView) findViewById(R.id.listView_main);

        NNMenuAdapter adapter = new NNMenuAdapter(this, list1, R.layout.view_menu_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (sliderView.isSlided()) {
                    sliderView.setSlided(!sliderView.isSlided());
                }
                initData1(position);
                adapter2.notifyDataSetInvalidated();
                sliderView.invalidate();
            }
        });

        listView2 = (ListView) findViewById(R.id.listView_menu);
        adapter2 = new NNMenuAdapter(this, list1, R.layout.view_menu_item);
        listView2.setAdapter(adapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MenuActivity.this, position + "", Toast.LENGTH_SHORT).show();
                sliderView.invalidate();
            }
        });
    }

    List<String> list1 = new ArrayList<>();

    private void initData1(int x) {
        list1.clear();
        list1.add("宝马" + x);
        list1.add("奥迪" + x);
        list1.add("保时捷" + x);
        list1.add("奔驰" + x);
        list1.add("法拉利" + x);
        list1.add("宝骏" + x);
        list1.add("现代" + x);
        list1.add("宝马" + x);
        list1.add("奥迪" + x);
        list1.add("保时捷" + x);
        list1.add("奔驰" + x);
        list1.add("法拉利" + x);
        list1.add("宝骏" + x);
        list1.add("现代" + x);
        list1.add("宝马" + x);
        list1.add("奥迪" + x);
        list1.add("保时捷" + x);
        list1.add("奔驰" + x);
        list1.add("法拉利" + x);
        list1.add("宝骏" + x);
        list1.add("现代" + x);
        list1.add("宝马" + x);
        list1.add("奥迪" + x);
        list1.add("保时捷" + x);
        list1.add("奔驰" + x);
        list1.add("法拉利" + x);
        list1.add("宝骏" + x);
        list1.add("现代" + x);
        list1.add("宝马" + x);
        list1.add("奥迪" + x);
        list1.add("保时捷" + x);
        list1.add("奔驰" + x);
        list1.add("法拉利" + x);
        list1.add("宝骏" + x);
        list1.add("现代" + x);
        list1.add("宝马" + x);
        list1.add("奥迪" + x);
        list1.add("保时捷" + x);
        list1.add("奔驰" + x);
        list1.add("法拉利" + x);
        list1.add("宝骏" + x);
        list1.add("现代" + x);
        list1.add("宝马" + x);
        list1.add("奥迪" + x);
        list1.add("保时捷" + x);
        list1.add("奔驰" + x);
        list1.add("法拉利" + x);
        list1.add("宝骏" + x);
        list1.add("现代" + x);
    }

}