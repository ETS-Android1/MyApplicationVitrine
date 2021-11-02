package com.example.myapplicationvitrine;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AppelToast {

    public static void displayCustomToast(Context context, String toastText) {

        final Toast toast;

        toast = Toast.makeText(context, toastText, Toast.LENGTH_LONG);
        toast.show();

    }
}
