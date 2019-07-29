package com.chennikawangmai.chenproject;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Asteridbtw extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    int i;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        i = bundle.getInt("page");
        final Bundle b = new Bundle();
        setContentView(R.layout.activity_asteridbtw);
        fragmentManager = getSupportFragmentManager();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (findViewById(R.id.cont) != null) {
                    toastMessage("null");
                    if (savedInstanceState != null) {
                        return;
                    }
                    b.putInt("page", i);
                    Fragment asteroidlist = new asteroidfragments();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.cont, asteroidlist, null);
                    asteroidlist.setArguments(b);
                    fragmentTransaction.commit();

                    toastMessage("loading...");

                }
            }

        }, 3000);
    }


      /*  if(findViewById(R.id.cont)!=null)
        {toastMessage("null");
            if(savedInstanceState!=null)
        {return;}
            b.putInt("page",i);
             Fragment asteroidlist=new asteroidfragments();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.cont,asteroidlist,null);
            asteroidlist.setArguments(b);
            fragmentTransaction.commit();

toastMessage("loading...");

        }*/


    private void toastMessage(String message){

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }
}
/*Fragment1 frag = new Fragment1();
FragmentManager manager = getSupportFragmentManager();
FragmentTransaction transaction = manager.beginTransaction();
transaction.add(R.id.mainlayout,frag,"Test Fragment");
transaction.commit();*/