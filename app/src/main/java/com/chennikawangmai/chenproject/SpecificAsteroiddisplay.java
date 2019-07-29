package com.chennikawangmai.chenproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpecificAsteroiddisplay extends AppCompatActivity {
    Integer idsend;
    String getid;
    SpecificAsteroid spi;
    TextView tv;
    String Content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_asteroiddisplay);
        tv=(TextView)findViewById(R.id.description);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
          getid=bundle.getString("id").toString();
          idsend=Integer.parseInt(getid);
        }
        final Retrofit retrofit= new Retrofit.Builder().baseUrl("https://www.neowsapp.com/").addConverterFactory(GsonConverterFactory.create()).build();
        Nasaapi api=retrofit.create(Nasaapi.class);
        Call<SpecificAsteroid> call=api.getSpecifiAsteroid(idsend);
        call.enqueue(new Callback<SpecificAsteroid>() {
            @Override
            public void onResponse(Call<SpecificAsteroid> call, Response<SpecificAsteroid> response) {
               spi=response.body();
               Content=new String();
               Content+="The Id of the asteroid is "+spi.idi+" and the name of the asteroid is "+spi.name+"\n";
               Content+="The minimum estimated diameter is "+spi.estimatedDiameter.k.estimated_diameter_min+" Km\n";
               if(spi.is_potentially_hazardous_asteroid==true)
                   Content+="The asteroid is potentially dangerous!";
               else
                   Content+="The asteroid is not potentially dangerous";

               tv.append(Content);

            }

            @Override
            public void onFailure(Call<SpecificAsteroid> call, Throwable t) {
                toastMessage(t.getCause().toString());

            }
        });
    }
    private void toastMessage(String message){

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }
}
