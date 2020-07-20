package com.example.tp3aminetouq2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment implements  View.OnClickListener {
    private OnButtonClickedListener mCallback;
    private View rootView;
    EditText txtEmail;
    EditText txtPassword;
    Button btnOk;
    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      rootView=inflater.inflate(R.layout.fragment_login, container, false);
      txtEmail = rootView.findViewById(R.id.txtEmail);
      txtPassword=rootView.findViewById(R.id.txtPassword);
      btnOk=rootView.findViewById(R.id.btnOk);
      btnOk.setOnClickListener(this);
      return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.createCallbackToParentActivity();
    }


    @Override
    public void onClick(View view) {
        mCallback.onButtonClicked(view);
    }
    private void createCallbackToParentActivity(){
        try {
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }
}

