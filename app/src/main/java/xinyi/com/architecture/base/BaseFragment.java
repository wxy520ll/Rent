package xinyi.com.architecture.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by wxy on 2017/9/11.
 * 非mvp的fragmenrt
 *
 */

public abstract class BaseFragment extends Fragment {

	public View contentView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		contentView=inflater.inflate(getLayoutResource(),null,false);
		ButterKnife.bind(this,contentView);
		initView();
		return contentView;
	}

	public abstract void initView();

	@LayoutRes
	public abstract int getLayoutResource();
}
