package com.ruhaly.androidsdk;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ruhaly.androidsdk.baseapi.BaseActivity;
import com.ruhaly.androidsdk.bean.UserBean;
import com.ruhaly.androidsdk.widget.TimeCountView;
import com.ruhaly.androidsdk.widget.TimeCountViewListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 测试类
 * [一句话功能简述]<BR>
 * [功能详细描述]
 *
 * @author hlr
 * @version [AndroidSDK, 2015年5月28日]
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.button1)
    public RecordButton b;

    @Bind(R.id.timeCountView)
    public TimeCountView timeCountView;

    @Bind((R.id.recyclerView))
    public RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;


    public MyAdapter adapter;


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        List<UserBean> list;


        class ViewHolder extends RecyclerView.ViewHolder {

            public TextView tvName;

            public TextView tvId;

            public Button btnRemove;

            public ViewHolder(View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tvName);
                tvId = (TextView) itemView.findViewById(R.id.tvId);
                btnRemove = (Button) itemView.findViewById(R.id.btnRemove);
                btnRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeData(getAdapterPosition());
                    }
                });
            }
        }

        public void removeData(int position) {
            list.remove(position);
            notifyItemRemoved(position);
            //ceshidddddd
            // notifyDataSetChanged();
        }

        public MyAdapter(List<UserBean> list) {
            this.list = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvName.setText(list.get(position).getUserName());
            holder.tvId.setText(list.get(position).getUserId());
        }

        @Override
        public int getItemCount() {
            return null == list ? 0 : list.size();
        }
    }


    public void initView() {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<UserBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            UserBean ub = new UserBean();
            ub.setUserId("+" + i);
            ub.setUserName("项目：" + i);
            list.add(ub);
        }

        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initData() {

    }


    @Override
    public void initLayout(Bundle paramBundle) {

        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
        b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("height:" + v.getHeight() + "Button ->onTouch" + event.getY());

                return false;
            }
        });

        System.out.println("initLayout-->Thread.currentThread().getId():" + Thread.currentThread().getId());
        timeCountView.setOnTimeCountListener(new TimeCountViewListener() {
            @Override
            public void onFinishCount() {
                showToast("倒计时结束");
            }
        });

        initView();
    }

    @OnClick(R.id.timeCountView)
    public void click(View view) {
        timeCountView.countStart();

//        System.out.println("Button click->click");
//        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

}
