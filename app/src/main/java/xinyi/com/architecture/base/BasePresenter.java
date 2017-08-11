package xinyi.com.architecture.base;

/**
 * Created by codeest on 2016/8/2.
 * Presenter基类
 */
public interface BasePresenter<T extends IBaseView>{

    void attachView(T view);

    void detachView();
}
