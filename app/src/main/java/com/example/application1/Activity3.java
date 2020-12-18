package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    CheckBox checkBox;
    Button btn_n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        checkBox=(CheckBox)findViewById(R.id.checkbox_agree);

        radioGroup=findViewById(R.id.radio_grupp);
        textView=findViewById(R.id.text_selected);



        //checkbox Toast shows if it is checked
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    String getCBData=checkBox.getText().toString();
                    Toast.makeText(Activity3.this, "On valinud: "+getCBData, Toast.LENGTH_SHORT).show();
                    next();
                }
                else {
                    String uncheckdata=checkBox.getText().toString();
                    Toast.makeText(Activity3.this, "Ei ole valinud: "+uncheckdata, Toast.LENGTH_SHORT).show();

                }

            }
        });

//submit button
        Button buttonSubmit=findViewById(R.id.btn_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                textView.setText("Sinu poolt valitud puuvili on: " + radioButton.getText());

            }
        });
    }
    //button on next page
    public void next(){
        btn_n=(Button)findViewById(R.id.btn_next);
        btn_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1=new Intent(Activity3.this,Activity4.class);
                startActivity(t1);
            }
        });


    }


        public void checkButton(View view){
            int radioId=radioGroup.getCheckedRadioButtonId();
            radioButton=findViewById(radioId);
            Toast.makeText(this, "Valitud radio button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
        }



}