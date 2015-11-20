package com.codepath.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {
    String editStr = "";
    int position = 0;
    EditText etEditItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Bundle data = getIntent().getExtras();
        editStr = data.getString("SimpleTodo.ListView.data");
        position = data.getInt("SimpleTodo.ListView.position");
        etEditItem = (EditText) findViewById(R.id.etEdit);
        etEditItem.setText(editStr);
        etEditItem.setSelection(etEditItem.getText().length());

    }
    public void onSave(View v) {

        EditText etEditItem = (EditText) findViewById(R.id.etEdit);
        String itemText = etEditItem.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("SimpleTodo.ListView.data", itemText);
        returnIntent.putExtra("SimpleTodo.ListView.position", position);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }


}
