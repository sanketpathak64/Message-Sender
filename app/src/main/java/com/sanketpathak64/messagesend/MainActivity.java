package com.sanketpathak64.messagesend;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber, message;
    Button sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.phone);
        message = findViewById(R.id.message);
        sendMessage = findViewById(R.id.sendButton);

        sendMessage.setOnClickListener(view -> {
            String phoneNumberStr = phoneNumber.getText().toString();
            String messageStr = message.getText().toString();
            String url = getMessageUrl(phoneNumberStr, messageStr);

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }

    private String getMessageUrl(String phoneNumber, String message) {
        final String messageUrl = "https://wa.me/" + phoneNumber + "?text=" + message;
        Log.e(TAG, "getMessageUrl: " + messageUrl);
        return messageUrl;
    }
}