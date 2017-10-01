package xinyi.com.architecture.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import xinyi.com.architecture.base.BaseMvpFragment;
import xinyi.com.architecture.di.scope.FragmentScope;

/**
 * Created by wxy on 2017/9/11.
 */
@Module
public class FragmentModule {

	private BaseMvpFragment baseFragment;

	public FragmentModule(BaseMvpFragment baseFragment) {
		this.baseFragment = baseFragment;
	}
	/**
	 * Expose the activity to dependents in the graph.
	 */

	@FragmentScope
	@Provides
	Activity provideActivity() {
		return this.baseFragment.getActivity();
	}
}
