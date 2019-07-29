package com.chennikawangmai.chenproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APODenterdate extends AppCompatActivity {
    private static final String TAG = "APODenterdate";
    EditText et;
    TextView tv;
    String date1;
    String monthl;
    String dayl;
    List<apod> apods;
    String[] hdurl1;
    String date;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apodenterdate);


        tv=(TextView)findViewById(R.id.txtv);
       tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        APODenterdate.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                monthl=new String();
                if(month<=9)
                {monthl="0"+month;}
                else
                {
                    monthl=""+month;
                }
                if(day<=9)
                {
                    dayl="0"+day;
                }
                else
                {
                    dayl=""+day;
                }
                tv.setText(date);date1=new String();date1=year+"-"+monthl+"-"+dayl;

                final Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.nasa.gov/").addConverterFactory(GsonConverterFactory.create()).build();
                Nasaapi api= retrofit.create(Nasaapi.class);
                Map<String,String> parameters=new HashMap<>();
                parameters.put("start_date",date1);parameters.put("end_date",date1);
                Call<List<apod>> call=api.getApod(parameters);
                call.enqueue(new Callback<List<apod>>() {
                    @Override
                    public void onResponse(Call<List<apod>> call, Response<List<apod>> response) {
                        apods=response.body();
                        if(apods!=null)
                        {hdurl1=new String[apods.size()];
                            for(int i=0;i<apods.size();i++)
                            {
                                hdurl1[i]= apods.get(i).getHdurl();
                            }
                            browser1(view);}
                        else
                            toastMessage("The Photo has not been uploaded yet");
                    }

                    @Override
                    public void onFailure(Call<List<apod>> call, Throwable t) {

                    }
                });
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: yyyy/MM/dd: " + year + "/" + month + "/" + day);
                date=new String();

              date = year + "-" + month + "-" + day;

            }
        };


       // Date date=new SimpleDateFormat("mm/DD/yyyy").parse("dfjdfb");

    }

    public void browser1(View view)
    {
        Intent browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse(hdurl1[0]));
        startActivity(browserintent);
    }
    private void toastMessage(String message){

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }
}
