/*
 * Copyright (C) 2016 .all right reserved for Esfandune.ir & Mohammad Rahmani
 * salam
 * in source ba zahmate faravani tahiye va montasher shode
 * lotfan az enteshare source khoddari farmaeid.
 * in kar be lahaze ghanuni va shar'i gheire ghanuni mibashad
 * lotfan baraye hemayat az ma dustane barnamenevise khod ra be Esfandune.ir hedayat konid.
 * ba tashakor az shoma
 * MOhammad Rahmani
 */

package ir.NMA.pouyamansournia.smart.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import ir.NMA.pouyamansournia.smart.R;
import ir.NMA.pouyamansournia.smart.TCP.Alert;
import ir.NMA.pouyamansournia.smart.TCP.TCPSocket;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends AppCompatActivity implements TCPSocket.TcpSocketEventListener {

    FloatingActionButton show, off, set;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageButton pluga, plugb, plugc, plugd, pluge, plugf;


    Switch connectionButton;

    EditText hostEditText;
    EditText portEditText;

    ProgressDialog connectionProgressDialog = null;

    TCPSocket tcpSocket;
    boolean isConnected = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("smart", 0);
        editor = sharedPreferences.edit();

        //ejra shodane safe smart faghat dar bare aval
        Boolean intro = sharedPreferences.getBoolean("FIRSTRUN", true);
        if (intro) {
            finish();
            Intent welcome = new Intent(MainActivity.this, Welcome.class);
            startActivity(welcome);
            editor.putBoolean("FIRSTRUN", false);
            editor.apply();
        }

        show = (FloatingActionButton) findViewById(R.id.show);
        off = (FloatingActionButton) findViewById(R.id.float7);
        set = (FloatingActionButton) findViewById(R.id.float5);

        //vorud mojadad be safe smart
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Setting.class);
                startActivity(intent);
            }
        });

        Alert.init(this);

        pluga = (ImageButton) findViewById(R.id.pluga);

        pluga.setEnabled(false);/////////////////////////////////////////////////////////////////////////////////////////////////////////

        pluga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("A");
//                Toast.makeText(getApplicationContext(), "Plug A !", Toast.LENGTH_SHORT).show();
            }
        });

        plugb = (ImageButton) findViewById(R.id.plugb);

        plugb.setEnabled(false);///////////////////////////////////////////////////////////////////////////////////////////////////////////

        plugb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("B");
//                Toast.makeText(getApplicationContext(), "Plug B !", Toast.LENGTH_SHORT).show();
            }
        });
        plugc = (ImageButton) findViewById(R.id.imageButton4);
        plugc.setEnabled(false);
        plugc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("C");
//                Toast.makeText(getApplicationContext(), "Plug C !", Toast.LENGTH_SHORT).show();
            }
        });
        plugd = (ImageButton) findViewById(R.id.imageButton5);
        plugd.setEnabled(false);
        plugd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("D");
//                Toast.makeText(getApplicationContext(), "Plug D !", Toast.LENGTH_SHORT).show();
            }
        });
        pluge = (ImageButton) findViewById(R.id.plugebtn);
        pluge.setEnabled(false);
        pluge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("E");
//                Toast.makeText(getApplicationContext(), "Plug E !", Toast.LENGTH_SHORT).show();
            }
        });
        plugf = (ImageButton) findViewById(R.id.plugf);
        plugf.setEnabled(false);
        plugf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("F");
//                Toast.makeText(getApplicationContext(), "Plug F !", Toast.LENGTH_SHORT).show();
            }
        });

        connectionButton = (Switch) findViewById(R.id.switch1);
        connectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleConnection();
            }
        });
    }

    public void toggleConnection() {

        if (!isConnected) {
            connect();
            Toast.makeText(getApplicationContext(), "Connect !", Toast.LENGTH_SHORT).show();
        } else {
            disconnect();
            Toast.makeText(getApplicationContext(), "Disconnect !", Toast.LENGTH_SHORT).show();
        }
    }

    private void enableCommandButtons(boolean enable) {
        pluga.setEnabled(enable);
        plugb.setEnabled(enable);
        plugc.setEnabled(enable);
        plugd.setEnabled(enable);
        pluge.setEnabled(enable);
        plugf.setEnabled(enable);
    }

    private void disconnect() {
        tcpSocket.disconnect();
        connectionButton.setText("Connect to Server");
        isConnected = false;
        enableCommandButtons(false);
    }

    public void connect() {
        //        String hostAdddress = hostEditText.getText().toString();
        //        String portString = portEditText.getText().toString();
        String hostAdddress = "192.168.1.104";
        String portString = "8080";
        tcpSocket = new TCPSocket(hostAdddress, Integer.valueOf(portString), this);
    }

    @Override
    public void onConnectionError(TCPSocket.ConnectionErrorType connectionErrorType) {
    }

    @Override
    public void onSocketConnected() {
        connectionButton.setText("Disconnect");
        enableCommandButtons(true);
        isConnected = true;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.aboutus) {
            //sakhte dialoge darbare ma
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle(getString(R.string.dialog_title));
            alert.setMessage(getString(R.string.dialog_text));

            alert.setPositiveButton(getString(R.string.dialog_positive), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.NMA.ir"));
                    startActivity(intent);
                }
            });

            alert.setNegativeButton(getString(R.string.dialog_negative), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }
}