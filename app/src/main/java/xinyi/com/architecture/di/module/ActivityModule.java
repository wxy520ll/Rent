package xinyi.com.architecture.di.module;

import dagger.Module;
import dagger.Provides;
import xinyi.com.architecture.base.BaseMvpActivity;
import xinyi.com.architecture.di.scope.ActivityScope;

/**
 * Created by wxy on 2017/9/4.
 */

@Module
public class ActivityModule{

	private BaseMvpActivity mActivity;

	public ActivityModule(BaseMvpActivity activity) {
		this.mActivity = activity;
	}
	/**
	 * Expose the activity to dependents in the graph.
	 */
	@Provides
	@ActivityScope
	BaseMvpActivity provideBaseMvpActivity() {
		return this.mActivity;
	}


}
