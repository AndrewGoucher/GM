package com.wolkabout.hexiwear.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wolkabout.hexiwear.R;

public class Range extends AppCompatActivity implements View.OnClickListener{

    Button bSave,bDefault,bExit;
    EditText tin,tax,hin,hax,lin,lax;
    EditText ct,ch,cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range);
        //access to dabase to get current data
        this.setCurrentData();



        //access to database to check tin/tax..... is empty or not
        //if empty use setDefault
        //else load custom
        this.getCustom();

        //min/max
        tin=(EditText)findViewById(R.id.tin);
        tax=(EditText)findViewById(R.id.tax);
        hin=(EditText)findViewById(R.id.hin);
        hax=(EditText)findViewById(R.id.hax);
        lin=(EditText)findViewById(R.id.lin);
        lax=(EditText)findViewById(R.id.lax);

        //current
        ct=(EditText)findViewById(R.id.ct);
        ch=(EditText)findViewById(R.id.ch);
        cl=(EditText)findViewById(R.id.cl);

        //buttons
        bSave=(Button) findViewById(R.id.save);
        bSave.setOnClickListener(this);

        bDefault=(Button) findViewById(R.id.Default);
        bDefault.setOnClickListener(this);

        bExit=(Button) findViewById(R.id.exit);
        bExit.setOnClickListener(this);


    }

    /**
     *
     * this is the functionality behind the three buttons on the set range UI
     */
    @Override
    public void onClick(View view) {
        if(view.equals(bSave)){
            int itin,itax,ihin,ihax,ilin,ilax;
            if(!tin.getText().toString().equals(""))
                itin=Integer.parseInt(tin.getText().toString());
            else
                Toast.makeText(this,"enter a value",Toast.LENGTH_SHORT).show();

            if(!tax.getText().toString().equals(""))
                itax=Integer.parseInt(tax.getText().toString());
            else
                Toast.makeText(this,"enter a value",Toast.LENGTH_SHORT).show();

            if(!hin.getText().toString().equals(""))
                ihin=Integer.parseInt(hin.getText().toString());
            else
                Toast.makeText(this,"enter a value",Toast.LENGTH_SHORT).show();

            if(!hax.getText().toString().equals(""))
                ihax=Integer.parseInt(hax.getText().toString());
            else
                Toast.makeText(this,"enter a value",Toast.LENGTH_SHORT).show();

            if(!lin.getText().toString().equals(""))
                ilin=Integer.parseInt(lin.getText().toString());
            else
                Toast.makeText(this,"enter a value",Toast.LENGTH_SHORT).show();

            if(!lax.getText().toString().equals(""))
                ilax=Integer.parseInt(lax.getText().toString());
            else
                Toast.makeText(this,"enter a value",Toast.LENGTH_SHORT).show();

            //save to database...

        }else if(view.equals(bDefault)){
            this.setDefault();
        }else if(view.equals(bExit)){
            Intent main=new Intent(this,MyActivity.class);
            startActivity(main);
        }
    }

    /**
     * This is where we have our arbitrary default value assignment
     */
    public void setDefault(){
        tin.setText("10");
        tax.setText("30");

        hin.setText("60");
        hax.setText("70");

        lin.setText("0");
        lax.setText("100");
    }

    /**
     * This is  where we will retrieve the current monitored data from the data base or the hexiwear device, this aspect of the UI is for user convenience
     */
    public void setCurrentData(){
        //
    }

    /**
     * This method is for retrieving the custom range parameters, can be used on UI page load so that it displays their current range set up for ease when editing.
     */

    public void getCustom(){
        //
    }
}
