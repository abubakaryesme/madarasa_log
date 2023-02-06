package com.example.madarasalog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_show_records, btn_add_record;
    ImageButton btn_add_std;
    DbHandler dbHandler;
    ImageView git_link;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    Spinner stdSpinner;
    ArrayAdapter<Student> spinnerAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add_std=findViewById(R.id.std_add);
        btn_show_records = findViewById(R.id.vw_log);
        btn_add_record= findViewById(R.id.add_log);

        git_link = findViewById(R.id.git_link);
        dbHandler=new DbHandler(this);
        List<Student> students = dbHandler.selectAllStudents();

        //Adding Student DropDown:
        spinnerAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_spinner_item, students);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stdSpinner = findViewById(R.id.std_spinner);
        stdSpinner.setAdapter(spinnerAdapter);


        btn_add_std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.add_student_layout, null);
                builder.setView(dialogView);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText name = dialogView.findViewById(R.id.edit_name);
                        EditText rollno = dialogView.findViewById(R.id.edit_roll);
                        Student std=new Student(0,name.getText().toString(),rollno.getText().toString());
                        dbHandler.insertStudent(std);
                        List<Student> students = dbHandler.selectAllStudents();
                        spinnerAdapter = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_spinner_item, students);
                        spinnerAdapter.notifyDataSetChanged();
                        stdSpinner.setAdapter(spinnerAdapter);
                        Toast.makeText(MainActivity.this, "Student Added!", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        btn_show_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                Integer id = Integer.parseInt(stdSpinner.getSelectedItem().toString().split(":")[0]);
                ArrayList<RecordLog> records = dbHandler.selectAllRecords(id);
                RecordAdapter dataAdapter = new RecordAdapter(MainActivity.this, records);
                builder.setAdapter(dataAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"You have selected " + records.get(which),Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

//                //AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                Integer id = Integer.parseInt(stdSpinner.getSelectedItem().toString().split(":")[0]);
//                ArrayList<RecordLog> records = dbHandler.selectAllRecords(id);
//
//                //RecordAdapter dataAdapter = new RecordAdapter(MainActivity.this, records);
//                recyclerView = findViewById(R.id.reycle_view_log);
//                recyclerView.setHasFixedSize(true);
//                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//
//                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, records);
//                recyclerView.setAdapter(recyclerViewAdapter);

                //Intent intent = new Intent(getApplicationContext(),)

//                builder.setAdapter(recyclerViewAdapter, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"You have selected " + records.get(which),Toast.LENGTH_LONG).show();
//                    }
//                });
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();


            }
        });

        btn_add_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.add_record_layout, null);
                builder.setView(dialogView);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText rec_date, rec_sabak_line , rec_sabak_sip, rec_sabki, rec_manzil;
                        rec_date = dialogView.findViewById(R.id.edt_date);
                        rec_sabak_line = dialogView.findViewById(R.id.edt_line);
                        rec_sabak_sip = dialogView.findViewById(R.id.edt_sipara);
                        rec_sabki = dialogView.findViewById(R.id.edt_sabaqi);
                        rec_manzil = dialogView.findViewById(R.id.edt_manzil);
                        String date = rec_date.getText().toString();
                        Integer sabakLine =  Integer.parseInt(rec_sabak_line.getText().toString());
                        Integer sabakSipara =  Integer.parseInt(rec_sabak_sip.getText().toString());
                        Integer sabki =  Integer.parseInt(rec_sabki.getText().toString());
                        Integer manzil =  Integer.parseInt(rec_manzil.getText().toString());
                        Integer stdId =  Integer.parseInt(stdSpinner.getSelectedItem().toString().split(":")[0]);
                        if (date.isEmpty() || sabakLine<0 || sabakSipara<0 || sabakSipara>30 || sabki<0
                                || (sabki != 0 && sabakSipara != 0 && sabakSipara != sabki + 1)
                                || sabki>30 || manzil<0 || manzil>30)
                        {
                            Toast.makeText(MainActivity.this, "Record Not Added (Invalid Data)!!", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            RecordLog record = new RecordLog(0,stdId,date,sabakLine,sabakSipara,sabki,manzil);
                            dbHandler.insertRecord(record);
                            Toast.makeText(MainActivity.this, "Log Added!!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


        git_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });
    }


}