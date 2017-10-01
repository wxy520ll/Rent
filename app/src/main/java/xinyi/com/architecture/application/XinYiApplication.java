package xinyi.com.architecture.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.squareup.leakcanary.LeakCanary;

import xinyi.com.architecture.di.component.AppComponent;

import xinyi.com.architecture.di.module.AppModule;

/**
 * Created by wxy on 2017/8/8.
 */

public class XinYiApplication extends Application {

	public static XinYiApplication xinYiApplication;
	public static AppComponent appComponent;

	public static String path;

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		xinYiApplication = this;
		path=getExternalCacheDir().getAbsolutePath();
		//LeakCanary.install(this);
		//BlockCanary.install(xinYiApplication, new BlockCanaryContext()).start();
	}

	public AppComponent getAppComponent() {
		if (appComponent == null) {
			appComponent = DaggerAppComponent.builder()
					.appModule(new AppModule(this))
					.build();
		}
		return appComponent;
	}
}
