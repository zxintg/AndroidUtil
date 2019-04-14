package com.zxin.activity.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import com.orhanobut.logger.Logger;
import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.sort.adapter.MenuParentAdapter;
import com.zxin.sort.adapter.MyMenuAdapter;
import com.zxin.sort.drag.DragCallback;
import com.zxin.sort.drag.DragForScrollView;
import com.zxin.sort.drag.DragGridView;
import com.zxin.sort.drag.DragTipListener;
import com.zxin.root.bean.MenuEntity;
import com.zxin.root.util.FileUtil;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.view.CommonCrosswiseBar;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

public class MenuManageActivity extends BaseActivity implements DragTipListener {
	@BindView(R.id.ccb_menu_head)
	CommonCrosswiseBar mHeadView;
	@BindView(R.id.gridview)
	DragGridView dragGridView;
	@BindView(R.id.sv_index)
	DragForScrollView sv_index;
	@BindView(R.id.tv_drag_tip)
	TextView tv_drag_tip;;
	@BindView(R.id.expandableListView)
	ExpandableListView expandableListView;

	private static MyMenuAdapter adapterSelect;
	private static ArrayList<MenuEntity> menuList= new ArrayList<>();;
	private static MenuParentAdapter menuParentAdapter;
	private static List<MenuEntity> indexSelect = new ArrayList<>();

	@Override
	public  void initData() {
		mHeadView.setRightText("管理");
		expandableListView.setGroupIndicator(null);
		initMineMenu();
		initAllMenu();
	}

	private void initMineMenu() {
		//获取设置保存到本地的菜单
		List<MenuEntity> indexDataList = SharedPreferencesManager.getMineMenuList();
		if (indexDataList != null) {
			indexSelect.clear();
			indexSelect.addAll(indexDataList);
		}

		adapterSelect = new MyMenuAdapter(mContext, indexSelect,this);
		dragGridView.setAdapter(adapterSelect);

		dragGridView.setDragCallback(new DragCallback() {
			@Override
			public void startDrag(int position) {
				Logger.i("start drag at ", ""+ position);
				sv_index.startDrag(position);
			}
			@Override
			public void endDrag(int position) {
				Logger.i("end drag at " ,""+ position);
				sv_index.endDrag(position);
			}
		});
		dragGridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.e("setOnItemClickListener",adapterSelect.getEditStatue()+"");
				if(!adapterSelect.getEditStatue()){
					MenuEntity cateModel = indexSelect.get(position);
					initUrl(cateModel);
				}
			}
		});
		dragGridView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				if (mHeadView.getRightText().equals("管理")) {
					mHeadView.setRightText("完成");
					adapterSelect.setEdit();
					if(menuParentAdapter!=null){
						menuParentAdapter.setEdit();
					}
					tv_drag_tip.setVisibility(View.VISIBLE);
				}
				dragGridView.startDrag(position);
				return false;
			}
		});
	}

	@Override
	public int setLayout() {
		return R.layout.activity_menu_manage;
	}

	private void initAllMenu() {
		List<MenuEntity> indexAll =  FileUtil.getInstance().getAllMenuList();
		menuList.clear();
		try {
			MenuEntity index = new MenuEntity();
			index.setTitle("流程审批");
			index.setId("1");
			List<MenuEntity> indexLC=new ArrayList<>();
			for (int i = 0; i < indexAll.size(); i++) {
				if(indexAll.get(i).getId().equals("92e44b6a-027c-4cd5-b35e-f90d29fe093f")){
					indexLC.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("aa7f6c21-5227-4f4b-832e-e04b34a1389e")){
					indexLC.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("a708b6d3-b5f5-439e-9544-5dc0508fc34b")){
					indexLC.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("0c4ad7d6-cb7b-4a27-9adb-fbb82dbfe67f")){
					indexLC.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("3d8b4e65-09b9-4731-ba97-6b3b1e317290")){
					indexLC.add(indexAll.get(i));
				}
			}
			for (int i = 0; i < indexLC.size(); i++) {
				for (int j = 0; j < indexSelect.size(); j++) {
					if (indexLC.get(i).getTitle().equals(indexSelect.get(j).getTitle())) {
						indexLC.get(i).setSelect(true);
					}
				}
			}
			index.setChilds(indexLC);
			menuList.add(index);

			MenuEntity index1 = new MenuEntity();
			index1.setTitle("绩效考核");
			index1.setId("1");
	
			List<MenuEntity> indexJX=new ArrayList<>();
			for (int i = 0; i < indexAll.size(); i++) {
				if(indexAll.get(i).getId().equals("ac888f31-8392-4820-9254-49b11f71e2d3")){
					indexJX.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("afce4ddf-194a-492a-b4ce-db79fd14801f")){
					indexJX.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("8b2abd6b-18c2-4f8b-9990-b2d45f1aa91b")){
					indexJX.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("f5462bb1-7151-4d1c-8d8e-d3653dc53e9a")){
					indexJX.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("13673a54-fa67-4f02-aeea-e4725ffbc853")){
					indexJX.add(indexAll.get(i));
				}
				if (indexAll.get(i).getId().equals("14c0f70a-5f6a-47c9-9ea4-4356773aa225")) {
					indexJX.add(indexAll.get(i));
				}
				if (indexAll.get(i).getId().equals("e924e4a9-0698-4624-8947-66cf883e8809")) {
					indexJX.add(indexAll.get(i));
				}
			}
			for (int i = 0; i < indexJX.size(); i++) {
				for (int j = 0; j < indexSelect.size(); j++) {
					if (indexJX.get(i).getTitle().equals(indexSelect.get(j).getTitle())) {
						indexJX.get(i).setSelect(true);
					}
				}
			}
			index1.setChilds(indexJX);
			menuList.add(index1);

			MenuEntity index2 = new MenuEntity();
			index2.setTitle("其他");
			index2.setId("2");
	
			List<MenuEntity> indexQT=new ArrayList<>();
			for (int i = 0; i < indexAll.size(); i++) {
				if(indexAll.get(i).getId().equals("1437cd9c-4595-46cb-8fde-e866e43f0825")){
					indexQT.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("1cd85fc6-0b69-4f04-aa79-883c6ba8649e")){
					indexQT.add(indexAll.get(i));
				}
				if(indexAll.get(i).getId().equals("a4f08830-adaa-4412-9adf-55b9e773118e")){
					indexQT.add(indexAll.get(i));
				}
			}
			for (int i = 0; i < indexQT.size(); i++) {
				for (int j = 0; j < indexSelect.size(); j++) {
					if (indexQT.get(i).getTitle().equals(indexSelect.get(j).getTitle())) {
						indexQT.get(i).setSelect(true);
					}
				}
			}
			index2.setChilds(indexQT);
			menuList.add(index2);
			
			menuParentAdapter = new MenuParentAdapter(MenuManageActivity.this, menuList,this);
			expandableListView.setAdapter(menuParentAdapter);
	
			// expandableListView.expandGroup(6); // 在分组列表视图中 展开一组
			// expandableListView.isGroupExpanded(0); //判断此组是否展开
			for (int i = 0; i < menuParentAdapter.getGroupCount(); i++) {
				expandableListView.expandGroup(i);
			}
			expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
				@Override
				public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
					MenuEntity cateModel = menuList.get(groupPosition);
					return true;
				}
			});
			expandableListView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					// TODO Auto-generated method stub
					if (mHeadView.getRightText().equals("管理")) {
						MenuEntity cateModel = menuList.get(arg2);
						initUrl(cateModel);
					}
				}
			});

			expandableListView.setOnItemLongClickListener(new OnItemLongClickListener() {
				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					// TODO Auto-generated method stub
					if (mHeadView.getRightText().equals("管理")) {
						mHeadView.setRightText("完成");
						adapterSelect.setEdit();
						menuParentAdapter.setEdit();
					}
					return false;
				}
			});
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void initUrl(MenuEntity cateModel) {
		if (mHeadView.getRightText().equals("管理")) {
			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			String title = cateModel.getTitle();
			String strId = cateModel.getId();
			Toast.makeText(MenuManageActivity.this,title,Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void deleteMeun(MenuEntity indexData, int position) {
		for (int i = 0; i < menuList.size(); i++) {
			for (int k = 0; k < menuList.get(i).getChilds().size(); k++) {
				if (menuList.get(i).getChilds().get(k).getTitle().equals(indexData.getTitle())) {
					menuList.get(i).getChilds().get(k).setSelect(false);
				}
			}
		}
		if(menuParentAdapter!=null){
			menuParentAdapter.notifyDataSetChanged();
		}
		adapterSelect.notifyDataSetChanged();
	}

	@Override
	public void addMenu(MenuEntity menuEntity) {
		indexSelect.add(menuEntity);
		SharedPreferencesManager.saveMineMenu(indexSelect);
		for (int i = 0; i < menuList.size(); i++) {
			for (int k = 0; k < menuList.get(i).getChilds().size(); k++) {
				if (menuList.get(i).getChilds().get(k).getTitle().equals(menuEntity.getTitle())) {
					menuList.get(i).getChilds().get(k).setSelect(true);
				}
			}
		}
		menuParentAdapter.notifyDataSetChanged();
		adapterSelect.notifyDataSetChanged();
	}

	@OnClick({R.id.common_bar_leftBtn,R.id.common_bar_rightBtn})
	@Override
	public void onClick(View v) {
		switch (v.getId()) {

			case R.id.common_bar_leftBtn:
				onBackPressed();
				break;

			case R.id.common_bar_rightBtn:
				if (mHeadView.getRightText().equals("管理")) {
					mHeadView.setRightText("完成");
					adapterSelect.setEdit();
					if(menuParentAdapter!=null){
						menuParentAdapter.setEdit();
					}
					tv_drag_tip.setVisibility(View.VISIBLE);
				} else {
					mHeadView.setRightText("管理");
					tv_drag_tip.setVisibility(View.GONE);
					adapterSelect.endEdit();
					if(menuParentAdapter!=null){
						menuParentAdapter.endEdit();
					}
				}
				break;
		}
	}
}
