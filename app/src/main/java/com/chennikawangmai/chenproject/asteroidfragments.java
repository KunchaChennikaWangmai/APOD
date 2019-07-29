package com.chennikawangmai.chenproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class asteroidfragments extends Fragment {
private ListView listView;
private List<near_earth_objects> near_earth_objectsList;
private String[] kd;
Integer page;


    Asteroids asteroids;
    String content;


    String ts;
    ArrayAdapter arrayAdapter;
public asteroidfragments()
{
}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=getView().findViewById(R.id.listView);
        Bundle bg=this.getArguments();
        if(bg!=null)
        {
           page=bg.getInt("page");
        }
       // page=89;
        final Retrofit retrofit=new Retrofit.Builder().baseUrl("https://www.neowsapp.com/").addConverterFactory(GsonConverterFactory.create()).build();
      Nasaapi api= retrofit.create(Nasaapi.class);
        Call<Asteroids> call=api.getAsteroids(page);
        call.enqueue(new Callback<Asteroids>() {
            @Override
            public void onResponse(Call<Asteroids> call, Response<Asteroids> response) {
                asteroids=response.body();
                kd=new String[asteroids.nearEarthObjects.size()];
                for(int i=0;i<asteroids.nearEarthObjects.size();++i)
                {
                    kd[i]=asteroids.nearEarthObjects.get(i).id;
                }
                toastMessage("Here you go! your list  of asteroids for page "+page+" is ready to be explored!");
                arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,kd);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getActivity(),SpecificAsteroiddisplay.class);
                        Bundle c=new Bundle();
                        c.putString("id",listView.getItemAtPosition(position).toString());
                        intent.putExtras(c);
                        startActivity(intent);
                    }
                });

                listView.setAdapter(arrayAdapter);


            }

            @Override
            public void onFailure(Call<Asteroids> call, Throwable t) {
                toastMessage(t.getCause().toString());
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view=inflater.inflate(R.layout.activity_asteroidfragments,container,false);

    return (view);
    }

    private void toastMessage(String message){

        Toast.makeText(getContext(),message, Toast.LENGTH_SHORT).show();

    }
}
