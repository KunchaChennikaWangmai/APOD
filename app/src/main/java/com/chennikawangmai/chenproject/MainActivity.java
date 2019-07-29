package com.chennikawangmai.chenproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String link;
List<apod> apods;
String[] hdurl1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.mainlist);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.options)){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(getResources().getColor(android.R.color.background_light));
                tv.setTextSize(20);


                // Generate ListView Item using TextView
                return view;
            }
        };
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                if(listView.getItemAtPosition(position).equals("Asteroids"))

                {  Intent intent=new Intent(MainActivity.this,Asteroidsgetpage.class);
                startActivity(intent);}
               else  if(listView.getItemAtPosition(position).equals("Astronomy Picture of the Day(APOD)"))
                {
                    Date c = Calendar.getInstance().getTime();
                    System.out.println("Current time => " + c);
                    String Url="https://api.nasa.gov/planetary/apod?api_key=ooFR0RQAaILFONKCTfvAncp6xYqShL6nHW0RFnr9&";

                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = df.format(c);

                    link =new String();
                    final Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.nasa.gov/").addConverterFactory(GsonConverterFactory.create()).build();
                    Nasaapi api= retrofit.create(Nasaapi.class);
                    Map<String,String> parameters=new HashMap<>();
                    parameters.put("start_date",formattedDate);parameters.put("end_date",formattedDate);
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

                    toastMessage("loading...");
                }
               else
                {
                    Intent intentl=new Intent(MainActivity.this,APODenterdate.class);
                    startActivity(intentl);
                }

            }
        });
        listView.setAdapter(mAdapter);

    }
    private void toastMessage(String message){

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }
    public void browser1(View view)
    {
        Intent browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse(hdurl1[0]));
        startActivity(browserintent);
    }
}

        /*<item>Space Weather</item>
        <item>Keplers Planets</item>*/
