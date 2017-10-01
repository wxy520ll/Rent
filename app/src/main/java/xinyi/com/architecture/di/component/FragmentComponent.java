package xinyi.com.architecture.di.component;

import android.app.Activity;

import dagger.Component;
import xinyi.com.architecture.activity.fragment.CarFragment;
import xinyi.com.architecture.activity.fragment.CategoryFragment;
import xinyi.com.architecture.activity.fragment.HomePageFragment;
import xinyi.com.architecture.activity.fragment.MineFragment;
import xinyi.com.architecture.di.module.FragmentModule;
import xinyi.com.architecture.di.scope.FragmentScope;

/**
 * Created by wxy on 2017/9/11.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

	Activity getActivity();


	void inject(HomePageFragment homePageFragment);

	void inject(CategoryFragment categoryFragment);

	void inject(CarFragment carFragment);

	void inject(MineFragment mineFragment);

}
