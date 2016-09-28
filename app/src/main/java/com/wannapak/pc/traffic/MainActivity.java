package com.wannapak.pc.traffic;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Create ListView
        createListView();
    }//main method
    private void createListView(){
        MyData objMyData = new MyData();
        int[] intIcon = objMyData.icon();
        String[] strTitle = objMyData.title();
        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this,intIcon,strTitle);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(objMyAdapter);

        //Active When Click ListView
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myIntentToDetail(i);
            }
        });

    } //createListView

private void myIntentToDetail(int intClick) {
    Intent objInternet = new Intent(MainActivity.this, ShowDetailActivity.class);
    objInternet.putExtra("click", intClick);
    startActivity(objInternet);
}

    public void ClickAboutMe (View view){
        Intent objIntent = new Intent(Intent.ACTION_VIEW);
        objIntent.setData(Uri.parse("http://www.expertlab.ssru.ac.th"));
        startActivity(objIntent);
    } //click
}