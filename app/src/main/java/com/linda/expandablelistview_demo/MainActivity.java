package com.linda.expandablelistview_demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoulinda on 16/3/7.
 */
public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView(){

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        final List<String> parentList = new ArrayList<>();
        parentList.add("parent1");
        parentList.add("parent2");
        parentList.add("parent3");
        parentList.add("parent4");
        parentList.add("parent5");
        parentList.add("parent6");

        final Map<String,List<String>> map = new HashMap<>();

        List<String> childList1 = new ArrayList<>();
        childList1.add("parent1-child1");
        childList1.add("parent1-child2");
        childList1.add("parent1-child3");
        childList1.add("parent1-child4");
        childList1.add("parent1-child5");
        childList1.add("parent1-child6");
        map.put("parent1",childList1);

        List<String> childList2 = new ArrayList<>();
        childList2.add("parent2-child1");
        childList2.add("parent2-child2");
        childList2.add("parent2-child3");
        childList2.add("parent2-child4");
        childList2.add("parent2-child5");
        childList2.add("parent2-child6");
        map.put("parent2",childList2);

        List<String> childList3 = new ArrayList<>();
        childList3.add("parent3-child1");
        childList3.add("parent3-child2");
        childList3.add("parent3-child3");
        childList3.add("parent3-child4");
        childList3.add("parent3-child5");
        childList3.add("parent3-child6");
        map.put("parent3",childList3);

        List<String> childList4 = new ArrayList<>();
        childList4.add("parent4-child1");
        childList4.add("parent4-child2");
        childList4.add("parent4-child3");
        childList4.add("parent4-child4");
        childList4.add("parent4-child5");
        childList4.add("parent4-child6");
        map.put("parent4",childList4);

        List<String> childList5 = new ArrayList<>();
        childList5.add("parent5-child1");
        childList5.add("parent5-child2");
        childList5.add("parent5-child3");
        childList5.add("parent5-child4");
        childList5.add("parent5-child5");
        childList5.add("parent5-child6");
        map.put("parent5",childList5);

        List<String> childList6 = new ArrayList<>();
        childList6.add("parent6-child1");
        childList6.add("parent6-child2");
        childList6.add("parent6-child3");
        childList6.add("parent6-child4");
        childList6.add("parent6-child5");
        childList6.add("parent6-child6");
        map.put("parent6",childList6);

        expandableListView.setAdapter(new MyAdapter(parentList,map));

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this,"click + "+ (map.get(parentList.get(groupPosition)).get(childPosition)),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this,"click + "+ parentList.get(groupPosition),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
