package xinyi.com.architecture.activity.fragment;

import android.app.Activity;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.fingdo.statelayout.StateLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import javax.inject.Inject;

import butterknife.Bind;
import xinyi.com.architecture.R;
import xinyi.com.architecture.application.GlideImageLoader;
import xinyi.com.architecture.base.BaseMvpFragment;
import xinyi.com.architecture.model.main.BannerData;
import xinyi.com.architecture.presenter.main.HomeFraPresenter;
import xinyi.com.architecture.presenter.main.contract.HomeContract;

/**
 * Created by wxy on 2017/9/11.
 */

public class HomePageFragment extends BaseMvpFragment<HomeFraPresenter>implements HomeContract.HomeFragmentView{
	@Bind(R.id.tv_scan)
	LinearLayout tvScan;
	@Bind(R.id.tv_msg)
	LinearLayout tvMsg;
	@Bind(R.id.ed_content)
	EditText edContent;
	@Bind(R.id.banner)
	Banner banner;
	@Bind(R.id.appbar)
	AppBarLayout appbar;
	@Bind(R.id.m_recyclerview)
	RecyclerView mRecyclerview;
	@Bind(R.id.state_layout)
	StateLayout stateLayout;

	@Inject
	Activity activity;
	@Override
	public void initInject() {
		getFragmentComponent().inject(this);
		mRecyclerview.setLayoutManager(new LinearLayoutManager(activity));// 布局管理器。
		mRecyclerview.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));// 添加分割线。
		presenter.requestData();
	}
	@Override
	public void initView() {
		banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
		banner.setImageLoader(new GlideImageLoader());
		banner.setBannerAnimation(Transformer.Default);
		//设置自动轮播，默认为true
		banner.isAutoPlay(true);
		banner.setDelayTime(2000);
		banner.setIndicatorGravity(BannerConfig.RIGHT);

	}

	@Override
	public int getLayoutResource() {
		return R.layout.fragment_home;
	}


	@Override
	public void updateBannerAndItem(BannerData bannerData) {

	}

	@Override
	public void updateProducts() {

	}
}
