package xinyi.com.architecture.application;

import com.xinyi_tech.commonlibs.util.StringUtil;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import xinyi.com.architecture.utils.ToastUtil;

/**
 * Created by wxy on 2017/9/30.
 */

public class ErrorConsumer implements Consumer<Throwable> {
	@Override
	public void accept(@NonNull Throwable throwable) throws Exception {
		if (!StringUtil.isEmpty(throwable.getMessage())){
			ToastUtil.showShort(throwable.getMessage());
		}
	}
}
