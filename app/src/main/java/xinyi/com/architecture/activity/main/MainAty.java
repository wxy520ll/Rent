package xinyi.com.architecture.activity.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import xinyi.com.architecture.R;
import xinyi.com.architecture.activity.fragment.CarFragment;
import xinyi.com.architecture.activity.fragment.CategoryFragment;
import xinyi.com.architecture.activity.fragment.HomePageFragment;
import xinyi.com.architecture.activity.fragment.MineFragment;
import xinyi.com.architecture.base.BaseNorActivity;
import xinyi.com.architecture.model.main.MenuModel;

/**
 * Created by wxy on 2017/9/11.
 */

public class MainAty extends BaseNorActivity {


	@Bind(R.id.iv_home)
	ImageView ivHome;
	@Bind(R.id.fr_page1)
	RelativeLayout frPage1;
	@Bind(R.id.iv_category)
	ImageView ivCategory;
	@Bind(R.id.fr_page2)
	RelativeLayout frPage2;
	@Bind(R.id.iv_car)
	ImageView ivCar;
	@Bind(R.id.fr_page3)
	RelativeLayout frPage3;
	@Bind(R.id.iv_me)
	ImageView ivMe;
	@Bind(R.id.fr_page4)
	RelativeLayout frPage4;
	@Bind(R.id.ll_bottom_tab)
	LinearLayout llBottomTab;
	@Bind(R.id.content_layout)
	FrameLayout contentLayout;
	@Bind(R.id.line)
	View line;
	@Bind(R.id.rl_main)
	RelativeLayout rlMain;
	private HomePageFragment homePageFragment;
	private FragmentManager fm;

	private HashMap<Integer,MenuModel>mapFragment;

	@IdRes
	private int lastImageViewID;

	{
		mapFragment=new HashMap<>();
		mapFragment.put(R.id.iv_home,new MenuModel(new HomePageFragment(),R.mipmap.agr,R.mipmap.agq));
		mapFragment.put(R.id.iv_category,new MenuModel(new CategoryFragment(),R.mipmap.agn,R.mipmap.agm));
		mapFragment.put(R.id.iv_car,new MenuModel(new CarFragment(),R.mipmap.agl,R.mipmap.agk));
		mapFragment.put(R.id.iv_me,new MenuModel(new MineFragment(),R.mipmap.agt,R.mipmap.ags));
	}

	@Override
	public int getLayoutResource() {
		return R.layout.activity_main;
	}

	@Override
	public void initView() {
		setDefaultFragment();
	}

	private void setDefaultFragment() {
		fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		homePageFragment = new HomePageFragment();
		transaction.add(R.id.content_layout, homePageFragment);
		transaction.commit();
		lastImageViewID=R.id.iv_home;
		ivHome.setImageResource(R.mipmap.agr);
	}


	@OnClick({R.id.iv_home, R.id.iv_category, R.id.iv_car, R.id.iv_me})
	public void onViewClicked(View view) {
		ImageView imageView= (ImageView) view;
		MenuModel menuModel=mapFragment.get(view.getId());
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.content_layout,menuModel.getBaseMvpFragment());
		transaction.commit();
		ImageView lastImageView=(ImageView)findViewById(lastImageViewID);
		lastImageView.setImageResource(mapFragment.get(lastImageViewID).getNor_icon());
		imageView.setImageResource(menuModel.getSelect_icon());
		lastImageViewID=view.getId();
	}
}
