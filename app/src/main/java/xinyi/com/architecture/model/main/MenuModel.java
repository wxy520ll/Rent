package xinyi.com.architecture.model.main;

import xinyi.com.architecture.base.BaseMvpFragment;

/**
 * Created by wxy on 2017/9/11.
 * 将 fragment，底部tab 选中的图片，非选中的图片封装成一个model
 */

public class MenuModel {

	public BaseMvpFragment baseMvpFragment;

	private int select_icon;

	private int nor_icon;

	public MenuModel(BaseMvpFragment baseMvpFragment, int select_icon, int nor_icon) {
		this.baseMvpFragment = baseMvpFragment;
		this.select_icon = select_icon;
		this.nor_icon = nor_icon;
	}

	public BaseMvpFragment getBaseMvpFragment() {
		return baseMvpFragment;
	}

	public void setBaseMvpFragment(BaseMvpFragment baseMvpFragment) {
		this.baseMvpFragment = baseMvpFragment;
	}

	public int getSelect_icon() {
		return select_icon;
	}

	public void setSelect_icon(int select_icon) {
		this.select_icon = select_icon;
	}

	public int getNor_icon() {
		return nor_icon;
	}

	public void setNor_icon(int nor_icon) {
		this.nor_icon = nor_icon;
	}
}
