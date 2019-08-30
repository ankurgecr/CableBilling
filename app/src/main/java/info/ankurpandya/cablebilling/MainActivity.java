package info.ankurpandya.cablebilling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btnQr;
    ImageView imgQR;

    RequestQueue queue;
    String url = "https://api.ipify.org?format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        btnQr = findViewById(R.id.btn_qr);
        imgQR = findViewById(R.id.img_qr);

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("Qr Scan Success");
            }
        });
    }

    private void showMessage(String message) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("-- Request success --");
                        System.out.println(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("-- Request failed --");
                        error.printStackTrace();
                        System.out.println(error.getMessage());
                    }
                }
        );
        queue.add(stringRequest);
    }
}
