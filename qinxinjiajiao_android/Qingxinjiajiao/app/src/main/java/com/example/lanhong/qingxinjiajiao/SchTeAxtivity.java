package com.example.lanhong.qingxinjiajiao;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class SchTeAxtivity extends Activity implements View.OnClickListener,
        AdapterView.OnItemClickListener {


    //获取科目和年级按钮
    private Button grade_btn, sub_btn;
    //返回按钮
    private ImageView back_arr;
    //定义两个弹出框年级和科目
    PopupWindow subpoWind, gradepoWind;
    View contentView, contentView1;
    //sub_pouwin里的课程按钮
    private Button sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8;
    //grade_pouwin里的年级按钮
    private Button grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10, grade11, grade12;
    //保存选择的年级和科目
    private String sub_select = "语文", grade_select = "一年级", sub_select1 = "chinese";
    //保存颜色
    private Button sub_button, grade_button;
    //确定按钮
    private Button sure_select_sub, sure_select_grade;
    //显示教师列表Listview
    private ListView select_list_teach;
    //暂时存储教师姓名
    private String teach_name = "";
    //存储教师信息列表
    private String string_teach[] = new String[20];
    private Boolean isget = false;
    get_Select_Teach select = new get_Select_Teach();
    private String TAG = "SchTeAxtivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search);
        init();
    }

    //组件初始化
    public void init() {
        grade_btn = (Button) findViewById(R.id.grade);
        grade_btn.setOnClickListener(this);
        sub_btn = (Button) findViewById(R.id.subject_name);
        sub_btn.setOnClickListener(this);
        back_arr = (ImageView) findViewById(R.id.arrback);
        back_arr.setOnClickListener(this);
        select_list_teach = (ListView) findViewById(R.id.select_teacher);
        select_list_teach.setOnItemClickListener(this);
        sub_btn.setText("语文");
        grade_btn.setText("一年级");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrback:
                //...返回首页
                break;
            case R.id.grade:
                //显示年级
                gradePoWin();

                break;
            case R.id.subject_name:
                //显示科目
                subPoWin();
                break;
            case R.id.sub1:
                sub_select = "语文";
                sub_select1 = "chinese";
                sub_btn.setText(sub_select);
                set_subBack();
                sub1.setBackgroundResource(R.drawable.grade_edit1);
                sub_button = sub1;
                break;
            case R.id.sub2:
                sub_select = "数学";
                sub_select1 = "math";
                sub_btn.setText(sub_select);
                set_subBack();
                sub2.setBackgroundResource(R.drawable.grade_edit1);
                sub_button = sub2;
                break;
            case R.id.sub3:
                sub_select = "英语";
                sub_select1 = "english";
                sub_btn.setText(sub_select);
                set_subBack();
                sub3.setBackgroundResource(R.drawable.grade_edit1);
                sub_button = sub3;
                break;
            case R.id.sub4:
                sub_select = "政治";
                sub_select1 = "politics";
                sub_btn.setText(sub_select);
                set_subBack();
                sub4.setBackgroundResource(R.drawable.grade_edit1);
                sub_button = sub4;
                break;
            case R.id.sub5:
                sub_select = "地理";
                sub_select1 = "geography";
                sub_btn.setText(sub_select);
                set_subBack();
                sub5.setBackgroundResource(R.drawable.grade_edit1);
                sub_button = sub5;
                break;
            case R.id.sub6:
                sub_select = "物理";
                sub_select1 = "physical";
                sub_btn.setText(sub_select);
                set_subBack();
                sub6.setBackgroundResource(R.drawable.grade_edit1);
                sub_button = sub6;
                break;
            case R.id.sub7:
                sub_select = "生物";
                sub_select1 = "biology";
                sub_btn.setText(sub_select);
                set_subBack();
                sub7.setBackgroundResource(R.drawable.grade_edit1);
                sub_button = sub7;
                break;
            case R.id.sub8:
                sub_select = "化学";
                sub_select1 = "chemistry";
                sub_btn.setText(sub_select);
                set_subBack();
                sub8.setBackgroundResource(R.drawable.grade_edit1);
                sub_button = sub8;
                break;
            //确认选择的科目
            case R.id.sure_sub_select:
                subpoWind.dismiss();
                new Anothertask().execute((Void[]) null);
                break;
            //年级选择按钮
            case R.id.grade1:
                grade_select = "一年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade1.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade1;
                break;
            case R.id.grade2:
                grade_select = "二年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade2.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade2;
                break;
            case R.id.grade3:
                grade_select = "三年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade3.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade3;
                break;
            case R.id.grade4:
                grade_select = "四年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade4.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade4;
                break;
            case R.id.grade5:
                grade_select = "五年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade5.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade5;
                break;
            case R.id.grade6:
                grade_select = "六年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade6.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade6;
                break;
            case R.id.grade7:
                grade_select = "七年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade7.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade7;
                break;
            case R.id.grade8:
                grade_select = "八年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade8.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade8;
                break;
            case R.id.grade9:
                grade_select = "九年级";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade9.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade9;
                break;
            case R.id.grade10:
                grade_select = "高一";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade10.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade10;
                break;
            case R.id.grade11:
                grade_select = "高二";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade11.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade11;
                break;
            case R.id.grade12:
                grade_select = "高三";
                grade_btn.setText(grade_select);
                set_gradeBack();
                grade12.setBackgroundResource(R.drawable.grade_edit1);
                grade_button = grade12;
                break;
            case R.id.sure_grade_select:
                //在这里加载数据库信息，显示出符合条件的教师信息
                gradepoWind.dismiss();
                new Anothertask().execute((Void[]) null);
                break;

            default:
                break;
        }

    }

    //显示年级PopupWindow
    protected void subPoWin() {
        //加载PopupWindow的布局文件
        contentView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.sub_pouwin, null);
        //声明一个弹出框
        subpoWind = new PopupWindow(this.getWindowManager().getDefaultDisplay().getWidth(), 800);
        subpoWind.setContentView(contentView);
        //显示
        subpoWind.showAsDropDown(sub_btn);
        sub_init();
    }

    //显示年级PopupWindow
    protected void gradePoWin() {
        //加载PopupWindow的布局文件
        contentView1 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.grade_pouwin, null);
        //声明一个弹出框
        gradepoWind = new PopupWindow(this.getWindowManager().getDefaultDisplay().getWidth(), 900);
        gradepoWind.setContentView(contentView1);
        //显示
        gradepoWind.showAsDropDown(grade_btn);
        grade_init();
    }

    //sub——pouwin里的组件初始化
    protected void sub_init() {
        sub1 = (Button) contentView.findViewById(R.id.sub1);
        sub1.setOnClickListener(this);
        sub2 = (Button) contentView.findViewById(R.id.sub2);
        sub2.setOnClickListener(this);
        sub3 = (Button) contentView.findViewById(R.id.sub3);
        sub3.setOnClickListener(this);
        sub4 = (Button) contentView.findViewById(R.id.sub4);
        sub4.setOnClickListener(this);
        sub5 = (Button) contentView.findViewById(R.id.sub5);
        sub5.setOnClickListener(this);
        sub6 = (Button) contentView.findViewById(R.id.sub6);
        sub6.setOnClickListener(this);
        sub7 = (Button) contentView.findViewById(R.id.sub7);
        sub7.setOnClickListener(this);
        sub8 = (Button) contentView.findViewById(R.id.sub8);
        sub8.setOnClickListener(this);
        sure_select_sub = (Button) contentView.findViewById(R.id.sure_sub_select);
        sure_select_sub.setOnClickListener(this);
    }

    //grade——pouwin里的组件初始化
    protected void grade_init() {
        grade1 = (Button) contentView1.findViewById(R.id.grade1);
        grade1.setOnClickListener(this);
        grade2 = (Button) contentView1.findViewById(R.id.grade2);
        grade2.setOnClickListener(this);
        grade3 = (Button) contentView1.findViewById(R.id.grade3);
        grade3.setOnClickListener(this);
        grade4 = (Button) contentView1.findViewById(R.id.grade4);
        grade4.setOnClickListener(this);
        grade5 = (Button) contentView1.findViewById(R.id.grade5);
        grade5.setOnClickListener(this);
        grade6 = (Button) contentView1.findViewById(R.id.grade6);
        grade6.setOnClickListener(this);
        grade7 = (Button) contentView1.findViewById(R.id.grade7);
        grade7.setOnClickListener(this);
        grade8 = (Button) contentView1.findViewById(R.id.grade8);
        grade8.setOnClickListener(this);
        grade9 = (Button) contentView1.findViewById(R.id.grade9);
        grade9.setOnClickListener(this);
        grade10 = (Button) contentView1.findViewById(R.id.grade10);
        grade10.setOnClickListener(this);
        grade11 = (Button) contentView1.findViewById(R.id.grade11);
        grade11.setOnClickListener(this);
        grade12 = (Button) contentView1.findViewById(R.id.grade12);
        grade12.setOnClickListener(this);
        sure_select_grade = (Button) contentView1.findViewById(R.id.sure_grade_select);
        sure_select_grade.setOnClickListener(this);
    }

    //设置科目选择的背景颜色
    protected void set_subBack() {
        sub1.setBackgroundResource(R.drawable.grade_edit);
        sub2.setBackgroundResource(R.drawable.grade_edit);
        sub3.setBackgroundResource(R.drawable.grade_edit);
        sub4.setBackgroundResource(R.drawable.grade_edit);
        sub5.setBackgroundResource(R.drawable.grade_edit);
        sub6.setBackgroundResource(R.drawable.grade_edit);
        sub7.setBackgroundResource(R.drawable.grade_edit);
        sub8.setBackgroundResource(R.drawable.grade_edit);
    }

    //设置班级的选择颜色
    protected void set_gradeBack() {
        grade1.setBackgroundResource(R.drawable.grade_edit);
        grade2.setBackgroundResource(R.drawable.grade_edit);
        grade3.setBackgroundResource(R.drawable.grade_edit);
        grade4.setBackgroundResource(R.drawable.grade_edit);
        grade5.setBackgroundResource(R.drawable.grade_edit);
        grade6.setBackgroundResource(R.drawable.grade_edit);
        grade7.setBackgroundResource(R.drawable.grade_edit);
        grade8.setBackgroundResource(R.drawable.grade_edit);
        grade9.setBackgroundResource(R.drawable.grade_edit);
        grade10.setBackgroundResource(R.drawable.grade_edit);
        grade11.setBackgroundResource(R.drawable.grade_edit);
        grade12.setBackgroundResource(R.drawable.grade_edit);
    }

    //异步任务获取教师信息
    private class Anothertask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            // 对UI组件的更新操作,耗时的操作
            try {
                // 连接到服务器的地址
                String connectURL = getString(R.string.host) + "/teacher_pro/get_select_teach";
                // 填入用户名密码和连接地址
                isget = select.get_Teach(sub_select, grade_select, connectURL);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            // TODO Auto-generated method stub
            if (isget) {
                string_teach = select.result.split(",");
                Log.i(TAG, select.result);
                select_list_teach.setAdapter(new ArrayAdapter<String>(SchTeAxtivity.this, R.layout.array_adapt, string_teach));
            } else {
                Toast.makeText(SchTeAxtivity.this, "抱歉，没有满足你要查找的教师！", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //传递教师姓名，用来获取对应教师具体信息
        teach_name = string_teach[position];
        Intent intent = new Intent(SchTeAxtivity.this, ShowTeaDet_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString("teach_name", teach_name);
        bundle.putString("subject", sub_select);
        bundle.putString("par_phone", LoginActivity.phone);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
