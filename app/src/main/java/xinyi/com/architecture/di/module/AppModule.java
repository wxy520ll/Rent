package xinyi.com.architecture.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xinyi.com.architecture.application.XinYiApplication;

/**
 * Created by wxy on 2017/9/4.
 */
@Module
public class AppModule {

	private XinYiApplication application;
	public AppModule(XinYiApplication xinYiApplication){
		this.application=xinYiApplication;
	}

	@Provides
	@Singleton
	public XinYiApplication provideApplicationContext() {
		return application;
	}
}
