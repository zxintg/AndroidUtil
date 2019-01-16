package com.zxin.marry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.bean.TaskListCommon;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */

public class MyExpandableTaskAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<TaskListCommon.TaskCommon> taskCommonsList = new ArrayList<>();

    public MyExpandableTaskAdapter(Context mContext,List<TaskListCommon.TaskCommon> taskCommonsList) {
        this.mContext = mContext;
        this.taskCommonsList = taskCommonsList;
    }

    @Override
    public TaskListCommon.TaskCommon.Task getChild(int fatherPosition, int childPosition) {
        return taskCommonsList.get(fatherPosition).getTask().get(childPosition);
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder;
        if (convertView == null) {
            childHolder = new ChildHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_task_check, null);
            childHolder.textName = (CheckBox) convertView.findViewById(R.id.name);
            childHolder.textView = (TextView) convertView.findViewById(R.id.task_name);
            convertView.setTag(childHolder);
        }else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        childHolder.textName.setChecked(getChild(groupPosition,childPosition).getIsover() == 1);
        childHolder.textView.setText(getChild(groupPosition,childPosition).getTitle());
        return convertView;
    }

    @Override
    public int getGroupCount() {
        return taskCommonsList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return taskCommonsList.get(groupPosition).getTask().size();
    }

    @Override
    public TaskListCommon.TaskCommon getGroup(int groupPosition) {
        return taskCommonsList.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean paramBoolean, View convertView, ViewGroup parent) {
        GroupHolder groupHolder;
        if (convertView == null) {
            groupHolder = new GroupHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.group, null);
            groupHolder.textView = (TextView) convertView.findViewById(R.id.group);
            convertView.setTag(groupHolder);
        }else{
            groupHolder = (GroupHolder) convertView.getTag();
        }
        groupHolder.textView.setText(getGroup(groupPosition).getDate());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ChildHolder {
        CheckBox textName;
        TextView textView;
    }

    class GroupHolder {
        TextView textView;
    }
}
