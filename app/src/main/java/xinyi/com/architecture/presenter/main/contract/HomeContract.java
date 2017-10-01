package xinyi.com.architecture.presenter.main.contract;

import xinyi.com.architecture.base.BasePresenter;
import xinyi.com.architecture.base.IBaseView;
import xinyi.com.architecture.model.main.BannerData;

/**
 * Created by wxy on 2017/9/30.
 *
 * 主fragment的  ui 和业务操作接口
 */

public interface HomeContract {

	interface HomeFragmentView extends IBaseView{
		void updateBannerAndItem(BannerData bannerData);
		void updateProducts();
	}
	interface Presenter extends BasePresenter<HomeFragmentView> {

		void requestData();
	}

}
