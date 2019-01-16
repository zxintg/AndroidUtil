package com.zxin.sort.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxin.sort.R;
import com.zxin.sort.drag.DragAdapterInterface;
import com.zxin.sort.drag.DragTipListener;
import com.zxin.zxinlib.bean.MenuEntity;
import com.zxin.zxinlib.util.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;


public class MyMenuAdapter extends BaseAdapter implements DragAdapterInterface {
	private boolean IsEdit = false;
	private List<MenuEntity> dataList = new ArrayList<>();
	private Context context;
	private DragTipListener listener;

	public MyMenuAdapter(Context context, List<MenuEntity> menuEntityList, DragTipListener listener) {
		this.context = context;
		this.dataList = menuEntityList;
		this.listener = listener;
	}

	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		MenuEntity bean = dataList.get(position);
		Holder holder;
		if (convertView == null) {
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.view_item, null);
			holder.deleteImg = (ImageView) convertView.findViewById(R.id.delete_img);
			holder.iconImg = (ImageView) convertView.findViewById(R.id.icon_img);
			holder.nameTv = (TextView) convertView.findViewById(R.id.name_tv);
			holder.container = convertView.findViewById(R.id.item_container);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		holder.deleteImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (listener!=null)
					listener.deleteMeun(dataList.get(position),position);
				dataList.remove(position);
				SharedPreferencesManager.saveMineMenu(dataList);
			}
		});
		if (IsEdit) {
			holder.deleteImg.setVisibility(View.VISIBLE);
		} else {
			holder.deleteImg.setVisibility(View.GONE);
		}
        //获取资源图片
        int drawableId = context.getResources().getIdentifier(bean.getIco(),"mipmap", context.getPackageName());
        holder.iconImg.setImageResource(drawableId);

//		Glide.with(context).load(bean.getIco()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
//				.into(holder.iconImg);

		holder.nameTv.setText(bean.getTitle());
		holder.container.setBackgroundColor(Color.WHITE);
		return convertView;
	}

	class Holder {
		public ImageView deleteImg;
		public ImageView iconImg;
		public TextView nameTv;
		public View container;
	}

	@Override
	public void reOrder(int startPosition, int endPosition) {
		if (endPosition < dataList.size()) {
			MenuEntity object = dataList.remove(startPosition);
			dataList.add(endPosition, object);
			notifyDataSetChanged();
			SharedPreferencesManager.saveMineMenu(dataList);
		}
	}

	public void setEdit() {
		IsEdit = true;
		notifyDataSetChanged();
	}

	public void endEdit() {
		IsEdit = false;
		notifyDataSetChanged();
	}
	public boolean getEditStatue() {
		return IsEdit;
	}


}
