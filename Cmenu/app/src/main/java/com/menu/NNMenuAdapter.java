package com.menu;

import android.content.Context;
import android.widget.TextView;

import com.menu.wnadapter.WNBaseAdapter;
import com.menu.wnadapter.WNViewHolder;

import java.util.List;

/**
 * Created by wuyajun on 16/3/3.
 * <p>
 * 菜单适配器
 */
public class NNMenuAdapter extends WNBaseAdapter<Object> {

    private int selectedIndex = -1;

    public NNMenuAdapter(Context context, List<?> datas, int itemId) {
        super(context, datas, itemId);
    }

    @Override
    public void convertView(WNViewHolder holder, Object object, int position) {
        if (object instanceof String) {
            TextView textView = holder.getView(R.id.menu_item_title);
            textView.setText((String) object);
//            textView.setBackgroundResource(R.drawable.menu_item_bg);
//            if (selectedIndex != -1 && selectedIndex == position) {
//                textView.setBackgroundResource(R.drawable.menu_item_select_bg);
//            }
        }
    }

    public void setSelected(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
}
