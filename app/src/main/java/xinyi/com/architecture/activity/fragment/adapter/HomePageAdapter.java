package xinyi.com.architecture.activity.fragment.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import xinyi.com.architecture.R;

/**
 * Created by wxy on 2017/9/14.
 */

public class HomePageAdapter extends BaseQuickAdapter<Integer,BaseViewHolder> {
	public HomePageAdapter(@LayoutRes int layoutResId, @Nullable List<Integer> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, Integer item) {
		helper.setText(R.id.tv_test,""+item);
	}
}
