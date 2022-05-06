package com.mac.whatkilometers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView txt_dist;
    private Elements elements;
    private Elements elements1;
    private Document doc;
    private EditText et_from, et_to;
    private Button btn_calculate;
    private LinearLayout mainLayout;
    private String[] finalDist;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_dist = findViewById(R.id.txt_dist);
        et_to = findViewById(R.id.et_to);
        et_from = findViewById(R.id.et_from);
        btn_calculate = findViewById(R.id.btn_calculate);
        mainLayout=findViewById(R.id.mainLayout);
        pd= new ProgressDialog(this);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setMessage("Calculating...");
                pd.setCancelable(false);
                pd.show();
                if (!et_from.getText().toString().isEmpty() && !et_to.getText().toString().isEmpty()) {
                    contents contents = new contents();

                    contents.execute();
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
                } else {
                    Snackbar.make(btn_calculate,"Please enter correct details",Snackbar.LENGTH_SHORT).show();
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
                }


            }
        });


    }


    private class contents extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            try {



                String url = "https://www.google.com/search?q=distance+between" + et_from.getText().toString() + "to" + et_to.getText().toString();
                String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36";

                doc = Jsoup.connect(url).userAgent(userAgent).get();
                elements = doc.getElementsByClass("BbbuR uc9Qxb uE1RRc");
                if(elements.text().isEmpty()){
                    elements1 = doc.getElementsByClass("dDoNo FzvWSb vk_bk");


                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            try {


                if(elements.text().isEmpty()){

                    Snackbar.make(btn_calculate, elements1.text(), Snackbar.LENGTH_SHORT).show();



                    try {
                        if(elements1.text().contains("km")){

                            finalDist= elements1.text().split(",");
                            String finalLast = finalDist[0]+finalDist[1].replaceAll("km","");
                            txt_dist.setText(finalLast+ "km");

                        }else if(elements1.text().contains("mi")){
                            finalDist= elements1.text().split(",");
                            String finalLast = finalDist[0]+finalDist[1].replaceAll("mi","");
                            txt_dist.setText(finalLast + "mi");

                        }


                    } catch (Exception e) {
                        e.printStackTrace();


                    }

                }else{
                    Snackbar.make(btn_calculate, elements.text(), Snackbar.LENGTH_SHORT).show();

                    String finalDistance = elements.text().substring(elements.text().indexOf("(") + 1, elements.text().indexOf(")"));


                    try {
                        finalDist= finalDistance.split(",");
                        String finalLast = finalDist[0]+finalDist[1].replaceAll("km","");
                        txt_dist.setText(finalLast+" km");


                    } catch (Exception e) {
                        e.printStackTrace();
                        txt_dist.setText(finalDistance.replaceAll("km","")+"km");


                    }

                }
                pd.dismiss();




            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }


}