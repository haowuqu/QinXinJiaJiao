package com.example.lanhong.qingxinjiajiao;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class SucesActivity extends Activity implements View.OnClickListener,
        View.OnTouchListener {

    private ViewPager ViewPager;
    private ImageButton index_image, search_image, mes_image, me_image;
    //index里的组件
    public TextView local_text;
    public ImageView math,chinese,english,physical,politics,chemistry,biology,geography;
    private ViewFlipper vFlipper;
    //消息里的组件
    public TextView order_teach,order_sug,order_talk,order_cheap;
    PopupWindow cheap_window;
    //me里的组件初始化
    public LinearLayout use_mes;
    public TextView phone,plant,set;
    public ImageView icon_img,order_img,money_img,reward_img;
    public String phonenum="";
    /*
     * 用来设置左右来回滑动
     */
    private List<View> lists = new ArrayList<View>();
    private MyAdapter myAdapter;
    // 下边4个按钮，用来改变背景颜色
    private LinearLayout layout1, layout2, layout3, layout4;
    //图片轮播组件
    public int imageIds[];
    public String[] titles;
    public ArrayList<ImageView> images;
    public ArrayList<View> dots;
    public TextView title;
    public ViewPager mViewPager;
    public ViewPagerAdapter adapter;
    public int oldPosition = 0;//记录上一次点的位置
    public int currentItem; //当前页面
    private ScheduledExecutorService scheduledExecutorService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_index);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        phonenum=bundle.getString("phone");
        init();

    }

    //组件初始化
    @SuppressWarnings("deprecation")
    public void init(){
        index_image=(ImageButton)findViewById(R.id.index);
        search_image=(ImageButton)findViewById(R.id.search);
        mes_image=(ImageButton)findViewById(R.id.xiaoxi);
        me_image=(ImageButton)findViewById(R.id.me);
        // 加载4个layout,用来设置背景
        layout1=(LinearLayout)findViewById(R.id.layout1);
        layout2=(LinearLayout)findViewById(R.id.layout2);
        layout3=(LinearLayout)findViewById(R.id.layout3);
        layout4=(LinearLayout)findViewById(R.id.layout4);
        // 加载对应的布局文件
        View index=getLayoutInflater().inflate(R.layout.index, null);
        View search=getLayoutInflater().inflate(R.layout.search, null);
        View mes=getLayoutInflater().inflate(R.layout.mes, null);
        View me=getLayoutInflater().inflate(R.layout.me, null);
        lists.add(index);
        lists.add(search);
        lists.add(mes);
        lists.add(me);
        myAdapter=new MyAdapter(lists);
        ViewPager=(ViewPager)findViewById(R.id.viewPager);
        ViewPager.setAdapter(myAdapter);
        //设置底部按钮监听事件
        index_image.setOnClickListener(this);
        index_image.setOnTouchListener(this);
        search_image.setOnClickListener(this);
        search_image.setOnTouchListener(this);
        mes_image.setOnClickListener(this);
        mes_image.setOnTouchListener(this);
        me_image.setOnClickListener(this);
        me_image.setOnTouchListener(this);
        //index的 组件
        local_text=(TextView)index.findViewById(R.id.dizhi);
        local_text.setOnClickListener(this);
        //课程组件
        math=(ImageView)index.findViewById(R.id.math);
        math.setOnClickListener(this);
        chinese=(ImageView)index.findViewById(R.id.chinese);
        chinese.setOnClickListener(this);
        english=(ImageView)index.findViewById(R.id.english);
        english.setOnClickListener(this);
        physical=(ImageView)index.findViewById(R.id.physical);
        physical.setOnClickListener(this);
        politics=(ImageView)index.findViewById(R.id.politics);
        politics.setOnClickListener(this);
        chemistry=(ImageView)index.findViewById(R.id.chemistry);
        chemistry.setOnClickListener(this);
        biology=(ImageView)index.findViewById(R.id.biology);
        biology.setOnClickListener(this);
        geography=(ImageView)index.findViewById(R.id.geography);
        geography.setOnClickListener(this);
        //消息滚动通知
        vFlipper=(ViewFlipper)index.findViewById(R.id.marquee_view);
        vFlipper.addView(View.inflate(getApplicationContext(), R.layout.index_toutiao, null));
        vFlipper.addView(View.inflate(getApplicationContext(), R.layout.index_toutiao1, null));
        vFlipper.addView(View.inflate(getApplicationContext(), R.layout.index_toutiao2, null));
        vFlipper.addView(View.inflate(getApplicationContext(), R.layout.index_toutiao3, null));
        //热门名师
        //图片ID
        imageIds = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
        };
        //图片标题
        titles = new String[]{
                "热门老师",
                "教师节",
                "热门英语老师",
                "热门物理老师",
                "热门数学老师"
        };
        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i =0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));
        dots.add(findViewById(R.id.dot_4));

        title = (TextView)index.findViewById(R.id.image_title);
        title.setText(titles[0]);
        mViewPager = (ViewPager)index.findViewById(R.id.vp);
        adapter = new ViewPagerAdapter();
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                title.setText(titles[position]);
                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

        //search的 组件
        //message的 组件
        order_teach=(TextView)mes.findViewById(R.id.order_teach);
        order_sug=(TextView)mes.findViewById(R.id.order_suggest);
        order_talk=(TextView)mes.findViewById(R.id.order_talk);
        order_cheap=(TextView)mes.findViewById(R.id.order_cheaper);
        order_teach.setOnClickListener(this);
        order_sug.setOnClickListener(this);
        order_talk.setOnClickListener(this);
        order_cheap.setOnClickListener(this);
        //me的 组件
        use_mes=(LinearLayout)me.findViewById(R.id.user_message);
        use_mes.setOnClickListener(this);
        phone=(TextView)me.findViewById(R.id.phone_numbers);
        phone.setText("手机号："+phonenum);
        order_img=(ImageView)me.findViewById(R.id.order);
        order_img.setOnClickListener(this);
        money_img=(ImageView)me.findViewById(R.id.money);
        money_img.setOnClickListener(this);
        reward_img=(ImageView)me.findViewById(R.id.reward);
        reward_img.setOnClickListener(this);
        plant=(TextView)me.findViewById(R.id.plant);
        plant.setOnClickListener(this);
        set=(TextView)me.findViewById(R.id.sets);
        set.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            //首页按钮
            case R.id.index:
                ViewPager.setCurrentItem(0);
                break;
            /*
             * 首页组件监听事件
             * 跳转到各科教师显示界面
             */
            case R.id.math:
                Intent intent11=new Intent(SucesActivity.this, Showtea_Activity.class);
                Bundle bundle11=new Bundle();
                bundle11.putString("subject", "数学");
                bundle11.putString("phone",phonenum );
                intent11.putExtras(bundle11);
                startActivity(intent11);
                break;
            case R.id.chinese:
                Intent intent2=new Intent(SucesActivity.this, Showtea_Activity.class);
                Bundle bundle2=new Bundle();
                bundle2.putString("subject", "语文");
                bundle2.putString("phone",phonenum );
                intent2.putExtras(bundle2);
                startActivity(intent2);
                break;
            case R.id.english:
                Intent intent3=new Intent(SucesActivity.this, Showtea_Activity.class);
                Bundle bundle3=new Bundle();
                bundle3.putString("subject", "英语");
                bundle3.putString("phone",phonenum );
                intent3.putExtras(bundle3);
                startActivity(intent3);
                break;
            case R.id.physical:
                Intent intent4=new Intent(SucesActivity.this, Showtea_Activity.class);
                Bundle bundle4=new Bundle();
                bundle4.putString("subject", "物理");
                bundle4.putString("phone",phonenum );
                intent4.putExtras(bundle4);
                startActivity(intent4);
                break;
            case R.id.politics:
                Intent intent5=new Intent(SucesActivity.this, Showtea_Activity.class);
                Bundle bundle5=new Bundle();
                bundle5.putString("subject", "政治");
                bundle5.putString("phone",phonenum );
                intent5.putExtras(bundle5);
                startActivity(intent5);
                break;
            case R.id.chemistry:
                Intent intent6=new Intent(SucesActivity.this, Showtea_Activity.class);
                Bundle bundle6=new Bundle();
                bundle6.putString("subject", "化学");
                bundle6.putString("phone",phonenum );
                intent6.putExtras(bundle6);
                startActivity(intent6);
                break;
            case R.id.biology:
                Intent intent7=new Intent(SucesActivity.this, Showtea_Activity.class);
                Bundle bundle7=new Bundle();
                bundle7.putString("subject", "生物");
                bundle7.putString("phone",phonenum );
                intent7.putExtras(bundle7);
                startActivity(intent7);
                break;
            case R.id.geography:
                Intent intent8=new Intent(SucesActivity.this, Showtea_Activity.class);
                Bundle bundle8=new Bundle();
                bundle8.putString("subject", "地理");
                bundle8.putString("phone",phonenum );
                intent8.putExtras(bundle8);
                startActivity(intent8);
                break;
            //查找教师
            case R.id.search:
                Intent intent=new Intent(SucesActivity.this,SchTeAxtivity.class);
                startActivity(intent);
                break;
            //消息
            case R.id.xiaoxi:
                ViewPager.setCurrentItem(2);
                break;
            //消息界面的预约教师信息
            case R.id.order_teach:
                Intent order_teach=new Intent(SucesActivity.this,order_teachActivity.class);
                Bundle teach=new Bundle();
                teach.putString("phone", phonenum);
                order_teach.putExtras(teach);
                startActivity(order_teach);
                break;
            //消息界面的我的建议
            case R.id.order_suggest:
                Intent order_suggest=new Intent(SucesActivity.this,order_suggestActivity.class);
                Bundle suggest=new Bundle();
                suggest.putString("phone", phonenum);
                order_suggest.putExtras(suggest);
                startActivity(order_suggest);
                break;
            //消息界面的论坛
            case R.id.order_talk:
                Intent order_talk=new Intent(SucesActivity.this,order_talkActivity.class);
                Bundle talk=new Bundle();
                talk.putString("phone", phonenum);
                order_talk.putExtras(talk);
                startActivity(order_talk);
                break;
            //消息界面的优惠信息
            case R.id.order_cheaper:

                break;
            //我
            case R.id.me:
                ViewPager.setCurrentItem(3);
                break;
            //me_order
            case R.id.order:
                Intent order_intent=new Intent(SucesActivity.this,OrderActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("phone",phonenum );
                order_intent.putExtras(bundle);
                startActivity(order_intent);
                break;
            //me_usermes
            case R.id.user_message:
                break;
            //me_money
            case R.id.money:
                Intent money_intent=new Intent(SucesActivity.this,MoneyActivity.class);
                Bundle money_bundle=new Bundle();
                money_bundle.putString("phone",phonenum );
                money_intent.putExtras(money_bundle);
                startActivity(money_intent);
                break;
            //me_reward
            case R.id.reward:
                Intent reward_intent=new Intent(SucesActivity.this,RewardActivity.class);
                Bundle bundle1=new Bundle();
                bundle1.putString("phone",phonenum );
                reward_intent.putExtras(bundle1);
                startActivity(reward_intent);
                break;
            case R.id.plant:
                Intent plant_intent=new Intent(SucesActivity.this,PlantActivity.class);
                startActivity(plant_intent);
                break;
            case R.id.sets:
                Intent set_intent=new Intent(SucesActivity.this,SetActivity.class);
                startActivity(set_intent);
            default:
                break;
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            //首页按钮
            case R.id.index:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    layout1.setBackgroundColor(Color.rgb(152, 251, 152));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    layout1.setBackgroundColor(Color.parseColor("#F5F5F5"));
                }
                break;
            //查找教师
            case R.id.search:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    layout2.setBackgroundColor(Color.rgb(152, 251, 152));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    layout2.setBackgroundColor(Color.parseColor("#F5F5F5"));
                }
                break;
            //消息
            case R.id.xiaoxi:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    layout3.setBackgroundColor(Color.rgb(152, 251, 152));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    layout3.setBackgroundColor(Color.parseColor("#F5F5F5"));
                }
                break;
            //我
            case R.id.me:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    layout4.setBackgroundColor(Color.rgb(152, 251, 152));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    layout4.setBackgroundColor(Color.parseColor("#F5F5F5"));
                }
                break;
            default:
                break;
        }
        return false;
    }



    private class ViewPagerAdapter extends PagerAdapter {
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }
        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
            view.removeView(images.get(position));
        }
        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stu
            view.addView(images.get(position));
            return images.get(position);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //每隔2秒钟切换一张图片
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(), 2, 4, TimeUnit.SECONDS);
    }
    //切换图片
    private class ViewPagerTask implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            currentItem = (currentItem +1) % imageIds.length;
            //更新界面
            handler.obtainMessage().sendToTarget();
        }
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            // TODO Auto-generated method stub
            //设置当前页面
            mViewPager.setCurrentItem(currentItem);
        }
    };
    @Override
    protected void onStop(){
        super.onStop();
    }
}
