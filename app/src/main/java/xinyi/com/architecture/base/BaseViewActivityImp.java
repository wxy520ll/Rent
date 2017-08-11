package xinyi.com.architecture.base;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fingdo.statelayout.StateLayout;

import butterknife.Bind;
import xinyi.com.architecture.R;

/**
 * Created by wxy on 2017/8/11.
 */

public class BaseViewActivityImp extends AppCompatActivity implements IBaseView,View.OnClickListener {
	@Nullable
	@Bind(R.id.tool_bar)
	public Toolbar toolbar;


	@Nullable
	@Bind(R.id.state_layout)
	public StateLayout stateLayout;

	@Override
	public void showLoadingDialog() {

	}

	@Override
	public void showNoNetWork() {
		if (stateLayout!=null)
			stateLayout.showNoNetworkView();
	}

	@Override
	public void showLoading() {
		if (stateLayout!=null)
			stateLayout.showLoadingView();
	}

	@Override
	public void showLoadFail() {
		if (stateLayout!=null)
			stateLayout.showErrorView();
	}

	@Override
	public void showContentView() {
		if (stateLayout!=null)
			stateLayout.showContentView();
	}

	@Override
	public void showEmptyView() {
		if (stateLayout!=null)
			stateLayout.showEmptyView();
	}

	@Override
	public void onClick(View v) {

	}
}
