package com.chennikawangmai.chenproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Asteroidsgetpage extends AppCompatActivity {
    TextView tv;
    EditText et;
   int n3,k;
    Button b;
    public boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asteroidsgetpage);
        tv=(TextView)findViewById(R.id.testagp);
        et=(EditText)findViewById(R.id.page);
        b=(Button)findViewById(R.id.aster);




       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(isEmpty(et)) {
                   n3 = Integer.parseInt(et.getText().toString());
     if((n3>1000)||(n3<0))
       {
           toastMessage("Enter a number between 0 and 1000");
           et.setText("");
       }
       else
     { k=n3;
                   Intent intent = new Intent(Asteroidsgetpage.this, Asteridbtw.class);
                   Bundle bundle=new Bundle();
                   bundle.putInt("page",k);
                   intent.putExtras(bundle);
                   startActivity(intent);}
       }
       else
       {
         et.setText("");

         toastMessage("Enter a number");
               }


           }
       });





    }
    private void toastMessage(String message){

        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }

}
