package xinyi.com.architecture.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import xinyi.com.architecture.api.ServiceManager;
import xinyi.com.architecture.application.XinYiApplication;
import xinyi.com.architecture.di.module.AppModule;

/**
 * Created by wxy on 2017/9/4.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

	XinYiApplication getApplication();

	ServiceManager getServiceManager();//api请求对象

	void inject(Application application);
}
