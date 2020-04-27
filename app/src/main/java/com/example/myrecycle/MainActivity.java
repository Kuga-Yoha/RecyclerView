package com.example.myrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mrecyclerView;
 //   private RecyclerView.Adapter mAdapter; cannot access csutom methods
    private ExampleAdapter mAdapter;
    private  RecyclerView.LayoutManager mLayoutManager;

    private  ArrayList<ExampleItem> mexampleList ;
    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();;
        buildRecyclerView();
        setButtons();


             /*  exampleList.add(new ExampleItem(R.drawable.ic_audiotrack_black_24dp, "Line 9", "Line 10"));
        exampleList.add(new ExampleItem(R.drawable.ic_brightness_auto_black_24dp, "Line 11", "Line 12"));
        exampleList.add(new ExampleItem(R.drawable.ic_android_black_24dp, "Line 13", "Line 14"));
        exampleList.add(new ExampleItem(R.drawable.ic_audiotrack_black_24dp, "Line 15", "Line 16"));
        exampleList.add(new ExampleItem(R.drawable.ic_brightness_auto_black_24dp, "Line 17", "Line 18"));
        exampleList.add(new ExampleItem(R.drawable.ic_android_black_24dp, "Line 19", "Line 20"));
        exampleList.add(new ExampleItem(R.drawable.ic_audiotrack_black_24dp, "Line 21", "Line 22"));
        exampleList.add(new ExampleItem(R.drawable.ic_brightness_auto_black_24dp, "Line 23", "Line 24"));
        exampleList.add(new ExampleItem(R.drawable.ic_android_black_24dp, "Line 25", "Line 26"));
        exampleList.add(new ExampleItem(R.drawable.ic_audiotrack_black_24dp, "Line 27", "Line 28"));
        exampleList.add(new ExampleItem(R.drawable.ic_brightness_auto_black_24dp, "Line 29", "Line 30")); */








    }

    public void insertItem(int position){

        mexampleList.add(position, new ExampleItem(R.drawable.ic_android_black_24dp,"New Item at position"+ position,"This is Line 2"));
        mAdapter.notifyItemChanged(position);
    }

    public void removeItem(int position){
       //mAdapter.notifyItemChanged(position);

        mexampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text){
        mexampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }


    public void createExampleList(){

        mexampleList =new ArrayList<>();

        mexampleList.add(new ExampleItem(R.drawable.ic_android_black_24dp, "Line 1", "Line 2"));
        mexampleList.add(new ExampleItem(R.drawable.ic_audiotrack_black_24dp, "Line 3", "Line 4"));
        mexampleList.add(new ExampleItem(R.drawable.ic_brightness_auto_black_24dp, "Line 5", "Line 6"));
        mexampleList.add(new ExampleItem(R.drawable.ic_android_black_24dp, "Line 7", "Line 8"));

    }

  public void buildRecyclerView(){

      mrecyclerView = findViewById(R.id.recyclerView);
      mrecyclerView.setHasFixedSize(true);// keep recycler view size fixed
      mLayoutManager= new LinearLayoutManager(this);
      mAdapter = new ExampleAdapter(mexampleList);

      mrecyclerView.setLayoutManager(mLayoutManager);
      mrecyclerView.setAdapter(mAdapter);

      mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
          @Override
          public void onItemClick(int position) {
             changeItem(position,"CLicked");
          }

          @Override
          public void onDeleteClick(int position) {
           removeItem(position);
          }


      });


  }

  public void setButtons(){
      buttonInsert= findViewById(R.id.button_insert);
      buttonRemove= findViewById(R.id.button_remove);

      editTextInsert= findViewById(R.id.edittext_insert);
      editTextRemove=findViewById(R.id.edittext_remove);

      buttonInsert.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              int position= Integer.parseInt(editTextInsert.getText().toString());
              insertItem(position);



          }
      });

      buttonRemove.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              int position= Integer.parseInt( editTextRemove.getText().toString());
              removeItem(position);


          }
      });

  }
}


