package com.linda.expandablelistview_demo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by zhoulinda on 16/3/7.
 */
public class MyAdapter extends BaseExpandableListAdapter {
    private List<String> parentList;
    private Map<String,List<String>> map;
    public MyAdapter(List<String> parentList, Map<String,List<String>> map) {
        this.parentList = parentList;
        this.map = map;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return map.get(parentList.get(groupPosition)).size();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return map.get(parentList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = View.inflate(parent.getContext(),R.layout.adapter_child,null);
        }

        TextView item_child = (TextView) convertView.findViewById(R.id.item_child);
        item_child.setText(map.get(parentList.get(groupPosition)).get(childPosition));
        return convertView;
    }


    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentList.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = View.inflate(parent.getContext(),R.layout.adapter_parent,null);
        }

        TextView item_parent = (TextView) convertView.findViewById(R.id.item_parent);
        item_parent.setText(parentList.get(groupPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
