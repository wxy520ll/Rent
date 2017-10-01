package xinyi.com.architecture.api;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;



/**
 * Created by wxy on 2017/8/8.
 * 网络请求
 */
@Singleton
public class ServiceManager {

	public static final String IP = "";
	public static final String IMAGEIP = "";

	Context context;


	@Inject
	public ServiceManager(Context context){
		this.context=context;
	}

}
