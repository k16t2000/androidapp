package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    TextView textView, textView2, textView3;
    Switch aSwitch;
    Button btn, btn2;
    ImageView imgviev;
    private int current_image;//for images
    int [] images={R.drawable.mario,R.drawable.toadd};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView=(TextView)findViewById(R.id.result_text);
        textView.setVisibility(View.INVISIBLE);

        textView2=(TextView)findViewById(R.id.result_text2);
        textView2.setVisibility(View.INVISIBLE);


        buttononclick();
        init();


        aSwitch=(Switch) findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    textView2.setText("Switch is on");
                    textView2.setVisibility(View.VISIBLE);
                }
                else{
                    textView2.setText("Switch is off");
                }

            }
        });

    }

//button go to the next page
    public void init(){
        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t=new Intent(Activity2.this,Activity3.class);
                startActivity(t);//activation activity
            }
        });
    }


//button shows text and changing pictures
    public void buttononclick(){
        imgviev=(ImageView)findViewById(R.id.imageView);
        textView3=(TextView)findViewById(R.id.result_text3);
        btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                textView3.setText("Just clicked a button");
                current_image++;
                current_image=current_image % images.length;
                imgviev.setImageResource(images[current_image]);
            }
        });
    }




    public void change(View view)
    {
        boolean checked=((ToggleButton)view).isChecked();
        if(checked)
        {
            textView.setText("TextView is now visible,after turning button on");
            textView.setVisibility(View.VISIBLE);
        }
        else {
            textView.setText("");
        }
    }

}