package xinyi.com.architecture.di.component;

import dagger.Component;
import xinyi.com.architecture.activity.SplashAty;
import xinyi.com.architecture.base.BaseMvpActivity;
import xinyi.com.architecture.di.module.ActivityModule;
import xinyi.com.architecture.di.scope.ActivityScope;

/**
 * Created by wxy on 2017/9/4.
 */

@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
	//Exposed to sub-graphs.
	BaseMvpActivity getActivity();

	void inject(SplashAty splashAty);
}

