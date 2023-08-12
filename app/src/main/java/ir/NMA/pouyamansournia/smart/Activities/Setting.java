package ir.NMA.pouyamansournia.smart.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ir.NMA.pouyamansournia.smart.R;


public class Setting extends AppCompatActivity {
    FloatingActionButton tell, about;
    Button close, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        close = (Button) findViewById(R.id.close_button);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Close & Save !", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        save = (Button) findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), " Save !", Toast.LENGTH_LONG).show();
            }
        });

        tell = (FloatingActionButton) findViewById(R.id.tell);
        tell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent call_tell = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+982188569202"));
                startActivity(call_tell);
            }
        });
        about = (FloatingActionButton) findViewById(R.id.abouts);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent aboutsd = new Intent("android.intent.action.SplashCT");
                startActivity(aboutsd);
            }
        });


    }
}
