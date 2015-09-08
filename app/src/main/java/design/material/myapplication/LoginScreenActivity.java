package design.material.myapplication;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import DataFiles.UserDetails;


public class LoginScreenActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        toolbar = (Toolbar) findViewById(R.id.appBar_login);
        setSupportActionBar(toolbar);
        Button loginButton = (Button) findViewById(R.id.blogin);
        final EditText emailEditText = (EditText) findViewById(R.id.editText_usr);
        final EditText passEditText = (EditText) findViewById(R.id.editText_pass);
        AccountManager manager = AccountManager.get(this);
        Account[] accounts = manager.getAccountsByType("com.google");
        for (Account account : accounts){
            if(account.name.endsWith("gmail.com")){
                String gmailAddress = account.name;
                emailEditText.setText(gmailAddress);
            }
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetails userDetails = new UserDetails();
                userDetails.setEmailID(emailEditText.getText().toString());
                userDetails.setPassword(passEditText.getText().toString());
                Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT,userDetails.getEmailID());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_about_us) {
            startActivity(new Intent(LoginScreenActivity.this,AboutUsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
