package com.menu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wuyajun on 16/1/25.
 * <p>
 * 自定义 菜单
 */
public class NNMenu extends LinearLayout {

    private final int duration = 200;//动画移动速度
    private int mLayoutHeight = 350;//整体菜单高度

    private Context mContext;

    private View mBtmMenu;
    private View menuBg;
    private LinearLayout menuLvLayout;
    private LinearLayout menuLv;
    private LinearLayout menuCloseShank;
    private LinearLayout menuNoDataTip;

    private List mData1 = new ArrayList();
    private List mData2 = new ArrayList();

    private ListView list_l1, list_l2;
    private NNMenuAdapter menuAdapter1, menuAdapter2;

    public NNMenu(Context context) {
        super(context);
        mContext = context;
    }

    public NNMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void initMenuLayout(Context context) {
        mContext = context;

        initAdapter();
        initViews();
    }

    private void initAdapter() {
        menuAdapter1 = new NNMenuAdapter(mContext, mData1, R.layout.view_menu_item);
        menuAdapter2 = new NNMenuAdapter(mContext, mData2, R.layout.view_menu_item);
    }

    public void setData1(List list) {
        mData1.clear();
        mData1.addAll(list);
        if (menuAdapter1 != null) {
            menuAdapter1.notifyDataSetChanged();
        }
    }

    public void setList1Selected(int selected) {
        if (menuAdapter1 != null) {
            menuAdapter1.setSelected(selected);
            menuAdapter1.notifyDataSetChanged();
        }
    }

    public void setData2(List list) {
        mData2.clear();
        mData2.addAll(list);
        if (menuAdapter2 != null) {
            menuAdapter2.notifyDataSetChanged();
        }
        if (list_l2 != null) {
            list_l2.setSelection(0);
        }
    }

    private void initViews() {
        mBtmMenu = LayoutInflater.from(mContext).inflate(R.layout.view_menu, null);
        menuLvLayout = (LinearLayout) mBtmMenu.findViewById(R.id.menu_lv_layout);

        menuCloseShank = (LinearLayout) mBtmMenu.findViewById(R.id.close_shank);
        menuCloseShank.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hideMenu();
            }
        });

        menuLv = (LinearLayout) mBtmMenu.findViewById(R.id.menu_lv);
        menuNoDataTip = (LinearLayout) mBtmMenu.findViewById(R.id.no_data_tip);

        menuBg = mBtmMenu.findViewById(R.id.menu_bg);
        menuBg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hideMenu();
            }
        });

        list_l1 = (ListView) mBtmMenu.findViewById(R.id.list_l1);
        list_l2 = (ListView) mBtmMenu.findViewById(R.id.list_l2);

        list_l1.setDividerHeight(0);
        list_l2.setDividerHeight(0);

        list_l1.setAdapter(menuAdapter1);
        list_l2.setAdapter(menuAdapter2);

        addView(mBtmMenu);
    }

    //隐藏layout
    public void hideMenu() {
        if (menuLvLayout.getVisibility() == View.VISIBLE) {
            showOrHidMenu();
        }
    }

    //如果隐藏则显示layout，如果显示则隐藏layout
    public void showOrHidMenu() {
        if (menuLvLayout == null) return;
        if (menuBg == null) return;
        showOrHidLayout(menuLvLayout, menuBg);
    }

    public void setNoData(boolean isHaveData) {
        if (isHaveData) {
            menuLv.setVisibility(View.VISIBLE);
            menuNoDataTip.setVisibility(View.GONE);
        } else {
            menuLv.setVisibility(View.GONE);
            menuNoDataTip.setVisibility(View.VISIBLE);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void showOrHidLayout(final View view, final View viewBg) {
        if (View.GONE == view.getVisibility()) {
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationY", -dip2px(mContext, mLayoutHeight), 0F);
            animator1.setDuration(duration);
            animator1.setInterpolator(new DecelerateInterpolator());
            animator1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    view.setVisibility(View.VISIBLE);
                    showOrHidLayoutBg(viewBg, true);
                }
            });
            animator1.start();
        } else {
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationY", 0F, -dip2px(mContext, mLayoutHeight));
            animator1.setDuration(duration);
            animator1.setInterpolator(new DecelerateInterpolator());
            animator1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    showOrHidLayoutBg(viewBg, false);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.GONE);
                }
            });
            animator1.start();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void showOrHidLayoutBg(final View view, final boolean isShow) {
        ObjectAnimator oa = ObjectAnimator.ofFloat(view, "alpha", isShow ? 0F : 1F, isShow ? 1F : 0F);
        oa.setDuration(duration);
        oa.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                if (isShow) {
                    view.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (!isShow) {
                    view.setVisibility(View.GONE);
                }
            }
        });
        oa.start();
    }

    private AdapterView.OnItemClickListener onItemClickListener1;

    public void setList1Listener(AdapterView.OnItemClickListener onItemClickListener1) {
        this.onItemClickListener1 = onItemClickListener1;
        if (list_l1 != null && onItemClickListener1 != null) {
            list_l1.setOnItemClickListener(onItemClickListener1);
        }
    }

    private AdapterView.OnItemClickListener onItemClickListener2;

    public void setList2Listener(AdapterView.OnItemClickListener onItemClickListener2) {
        this.onItemClickListener2 = onItemClickListener2;
        if (list_l2 != null && onItemClickListener2 != null) {
            list_l2.setOnItemClickListener(onItemClickListener2);
        }
    }

    //util
    public static int dip2px(Context context, float dipValue) {
        if (context == null) {
            return (int) dipValue;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
