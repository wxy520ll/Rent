package xinyi.com.architecture.di.component;

import javax.inject.Singleton;

import dagger.Component;
import xinyi.com.architecture.application.XinYiApplication;
import xinyi.com.architecture.di.module.AppModule;

/**
 * Created by wxy on 2017/9/4.
 */
@Singleton
@Component(dependencies = AppModule.class)
public interface AppComponent {

	XinYiApplication getApplication();

	void Inject(XinYiApplication xinYiApplication);
}
