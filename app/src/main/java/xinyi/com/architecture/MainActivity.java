package xinyi.com.architecture;

import xinyi.com.architecture.base.BaseActivity;

public class MainActivity extends BaseActivity {

/*	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
*//*
		ServiceApi.getData("","http://news-at.zhihu.com/api/4/news/latest", TestModel.class,this)
				.subscribe(new Consumer<TestModel>() {
					@Override
					public void accept(@NonNull TestModel testModel) throws Exception {
						String s=testModel.getDate();
						ToastUtil.showShort(getApplicationContext(),"success");
					}
				}, new Consumer<Throwable>() {
					@Override
					public void accept(@NonNull Throwable throwable) throws Exception {
						String s=throwable.getLocalizedMessage();
						ToastUtil.showShort(getApplicationContext(),s);
					}
				});*//*
	}*/

	@Override
	public int getLayoutResource() {
		return 0;
	}

	@Override
	public void initView() {

	}

	@Override
	public void inject() {

	}
}
