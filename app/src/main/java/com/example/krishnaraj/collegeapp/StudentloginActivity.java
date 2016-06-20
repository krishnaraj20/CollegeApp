package com.example.krishnaraj.collegeapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentloginActivity extends Activity implements View.OnClickListener {
    EditText editRollno, editName, editPhone, editAddress, editDOB, editGender;
    Button btnAdd, btnDelete, btnModify, btnView, btnViewAll, btnShowInfo;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);

        editRollno = (EditText) findViewById(R.id.editRollno);
        editName = (EditText) findViewById(R.id.editName);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editDOB = (EditText) findViewById(R.id.editDOB);
        editGender = (EditText) findViewById(R.id.editGender);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnModify = (Button) findViewById(R.id.btnModify);
        btnView = (Button) findViewById(R.id.btnView);
        btnViewAll = (Button) findViewById(R.id.btnViewAll);
        btnShowInfo = (Button) findViewById(R.id.btnShowInfo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"Access Denied",Toast.LENGTH_SHORT ).show();
            }
        });
       // btnDelete.setOnClickListener(this);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"Access Denied",Toast.LENGTH_SHORT ).show();

            }
        });
        btnView.setOnClickListener(this);
        //btnViewAll.setOnClickListener(this);
        btnShowInfo.setOnClickListener(this);
        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,phone VARCHAR,address VARCHAR,dob VARCHAR,gender VARCHAR);");
    }

    public void onClick(View view) {
//        if (view == btnAdd) {
//            if (editRollno.getText().toString().trim().length() == 0 ||
//                    editName.getText().toString().trim().length() == 0 ||
//                    editPhone.getText().toString().trim().length() == 0 ||
//                    editAddress.getText().toString().trim().length() == 0 ||
//                    editDOB.getText().toString().trim().length() == 0 ||
//                    editGender.getText().toString().trim().length() == 0)
//
//            {
//                showMessage("Error", "Please Enter All Values");
//                return;
//            }
//            db.execSQL("INSERT INTO student VALUES('" + editRollno.getText() + "','" + editName.getText() +
//                    "','" + editPhone.getText() + "','" + editAddress.getText() + "','" + editDOB.getText() + "','" + editGender.getText() + "');");
//            showMessage("Success", "Record added");
//            clearText();
//        }
//        if (view == btnDelete) {
//            if (editRollno.getText().toString().trim().length() == 0) {
//                showMessage("Error", "Please enter Rollno");
//                return;
//            }
//            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno ='" + editRollno.getText() + "'", null);
//            if (c.moveToFirst()) {
//                db.execSQL("DELETE FROM student WHERE rollno='" + editRollno.getText() + "'");
//                showMessage("Success", "Record Deleted");
//            } else {
//                showMessage("Error", "Invalid Rollno");
//            }
//            clearText();
//        }
//          if (view == btnModify) {
//            if (editRollno.getText().toString().trim().length() == 0) {
//                showMessage("Error", "Please enter Rollno");
//                return;
//            }
//            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno ='" + editRollno.getText() + "'", null);
//            if (c.moveToFirst()) {
//                db.execSQL("UPDATE student SET name='" + editName.getText() + "',phone='" + editPhone.getText() +
//                        "',address='" + editAddress.getText() + "',dob='" + editDOB.getText() + "',gender='" + editGender.getText() + "' WHERE rollno ='" + editRollno.getText() + "'");
//                showMessage("Success", "Record Modified");
//            } else {
//                showMessage("Error", "Invalid Rollno");
//            }
//            clearText();
//        }
//        if (view == btnView) {
//            if (editRollno.getText().toString().trim().length() == 0) {
//                showMessage("Error", "Please enter Rollno");
//                return;
//            }
//            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno ='" + editRollno.getText() + "'", null);
//            if (c.moveToFirst()) {
//                editName.setText(c.getString(1));
//                editPhone.setText(c.getString(2));
//                editAddress.setText(c.getString(3));
//                editDOB.setText(c.getString(4));
//                editGender.setText(c.getString(5));
//            } else {
//                showMessage("Error", "Invalid Rollno");
//                clearText();
//            }
//        }
////        if (view == btnViewAll) {
//            Cursor c = db.rawQuery("SELECT * FROM student", null);
//            if (c.getCount() == 0) {
//                showMessage("Error", "No records found");
//                return;
//            }
//            StringBuffer buffer = new StringBuffer();
//            while (c.moveToNext()) {
//                buffer.append("Rollno: " + c.getString(0) + "\n");
//                buffer.append("Name: " + c.getString(1) + "\n");
//                buffer.append("Phone: " + c.getString(2) + "\n");
//                buffer.append("Address: " + c.getString(3) + "\n");
//                buffer.append("DOB: " + c.getString(4) + "\n");
//                buffer.append("Gender: " + c.getString(5) + "\n\n");
//            }
//            showMessage("Student Details", buffer.toString());
//        }
        if (view == btnShowInfo) {
            showMessage("College Database Management Application", "Developed By IT Rockers !!!");
        }
    }


    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        editRollno.setText("");
        editName.setText("");
        editPhone.setText("");
        editAddress.setText("");
        editDOB.setText("");
        editGender.setText("");
        editRollno.requestFocus();
    }

}

