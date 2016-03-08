package com.menu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private MenuDrawer mDrawer;
    private LayoutInflater mLayoutInflater = null;
    private View menuLayout;
    private View mainLayout;


    private TextView mFilter;
    private NNMenu btmMenuType;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDrawer = MenuDrawer.attach(this, MenuDrawer.Type.OVERLAY, Position.END);

        mLayoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        menuLayout = mLayoutInflater.inflate(R.layout.menu_layout, null);
        mainLayout = mLayoutInflater.inflate(R.layout.activity_main, null);

        mDrawer.setMenuView(menuLayout);
        mDrawer.setContentView(mainLayout);
        mDrawer.setMenuSize(800);

        mFilter = (TextView) mainLayout.findViewById(R.id.filter);
        mFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btmMenuType.showOrHidMenu();
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
            }
        });

        initData1();
        initData2();

        btmMenuType = (NNMenu) mainLayout.findViewById(R.id.select_img_menu);
        btmMenuType.initMenuLayout(this);
        btmMenuType.setList1Listener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btmMenuType.setList1Selected(position);
                btmMenuType.setData2(list2);
            }
        });
        btmMenuType.setList2Listener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        btmMenuType.setData1(list1);
        btmMenuType.setNoData(true);
    }

    List<String> list1 = new ArrayList<>();

    private void initData1() {
        list1.add("宝马");
        list1.add("奥迪");
        list1.add("保时捷");
        list1.add("奔驰");
        list1.add("法拉利");
        list1.add("宝骏");
        list1.add("现代");
    }

    List<String> list2 = new ArrayList<>();

    private void initData2() {
        list2.add("奔驰");
        list2.add("法拉利");
        list2.add("宝骏");
        list2.add("现代");
        list2.add("宝马");
        list2.add("奥迪");
        list2.add("保时捷");
        list2.add("奔驰");
        list2.add("法拉利");
        list2.add("宝骏");
        list2.add("现代");
        list2.add("宝马");
        list2.add("奥迪");
        list2.add("保时捷");
        list2.add("奔驰");
        list2.add("法拉利");
        list2.add("宝骏");
        list2.add("现代");
        list2.add("宝马");
        list2.add("奥迪");
        list2.add("保时捷");
        list2.add("奔驰");
        list2.add("法拉利");
        list2.add("宝骏");
        list2.add("现代");
        list2.add("宝马");
        list2.add("奥迪");
        list2.add("保时捷");
        list2.add("奔驰");
        list2.add("法拉利");
        list2.add("宝骏");
        list2.add("现代");
        list2.add("宝马");
        list2.add("奥迪");
        list2.add("保时捷");
    }
}
