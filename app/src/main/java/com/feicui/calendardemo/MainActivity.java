package com.feicui.calendardemo;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView date,selectTime;
    private ImageView select;
    private SimpleDateFormat simpleDateFormat;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date= (TextView) findViewById(R.id.date);
        selectTime= (TextView) findViewById(R.id.selectTime);
        select= (ImageView) findViewById(R.id.select);
        calendar=Calendar.getInstance(Locale.CHINA);//使用默认时区和语言环境获得一个日历
        //设置时间的格式
        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date.setText(simpleDateFormat.format(new Date()));
        hanlder.sendEmptyMessage(1);
//        date.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
         int year=calendar.get(Calendar.YEAR);
         int month=calendar.get(Calendar.MONTH)+1;//月份从零开始，我们正真获取到的月份需要+1
         int day=calendar.get(Calendar.DAY_OF_MONTH);
        //这个方法中只是创建出DetePickerDialog，及相应监听，在其他方法中调用显示
        datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                String str=year+"-"+month+"-"+day;
                selectTime.setText(str);
            }
        },year,month,day);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

    }

private Handler hanlder=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        hanlder.sendEmptyMessageDelayed(1,500);
       date.setText(simpleDateFormat.format(new Date()));

    }
};


}
