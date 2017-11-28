package starshines.numberfacts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity  {

    private static final String URL_DATA="http://numbersapi.com/random/"; // API  BASE URL
    Button btntrivia,btnmath,btndate,btnyear;
    TextView txtResponse,txtCategory;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btntrivia= (Button) findViewById(R.id.btntrivia);
        btnmath= (Button) findViewById(R.id.btnmath);
        btndate= (Button) findViewById(R.id.btndate);
        btnyear= (Button) findViewById(R.id.btnyear);
        txtResponse= (TextView) findViewById(R.id.txtResponse);
        txtCategory= (TextView) findViewById(R.id.txtcategory);

    }


    public void onClickTrivia(View view)
    {
        String url="";
    Toast.makeText(this," selected trivia",Toast.LENGTH_LONG).show();
        url=URL_DATA+"trivia";

        request(url);
    }



    public void onClickMath(View view)
    {
        String url="";
    Toast.makeText(this," selected math",Toast.LENGTH_LONG).show();
        url=URL_DATA+"math";
        request(url);
    }

    public void onClickDate(View view)
    {
        String url="";
    Toast.makeText(this," selected date",Toast.LENGTH_LONG).show();
        url=URL_DATA+"date";
        request(url);
    }
    public void onClickYear(View view)
    {
        String url="";
     Toast.makeText(this," selected year",Toast.LENGTH_LONG).show();
        url=URL_DATA+"year";
        request(url);
    }

    private void request(String url) {
        StringRequest stringRequest=new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        // Font path
                        String fontPath = "fonts/sofiaregular.otf";

// Loading Font Face
                        Typeface m_typeFace = Typeface.createFromAsset(getAssets(), fontPath);

// Applying font
                        txtResponse.setTypeface(m_typeFace);
                       txtResponse.setText(s);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(),"Error Fetching Data",Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
