package com.example.matthew.expandablelistviewtesting;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;


public class CustomDialogFragment extends DialogFragment {

    public static String messageText;
    public static Boolean showDialogUpdate = true;

    public CustomDialogFragment() {
        // Empty constructor required for DialogFragment
    }

    public static CustomDialogFragment newInstance(String Title) {
        CustomDialogFragment frag = new CustomDialogFragment();
        Bundle args = new Bundle();
        args.putString("New Message", Title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        final EditText message = (EditText) dialog.findViewById(R.id.message);

        dialog.findViewById(R.id.positive_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                messageText = message.getText().toString();
                MainActivity callingActivity = (MainActivity) getActivity();
                callingActivity.updateInterface();
                dismiss();
            }

        });


        return dialog;
    }


}