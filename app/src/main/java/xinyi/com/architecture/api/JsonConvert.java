package xinyi.com.architecture.api;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.convert.Converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by wxy on 2017/8/8.
 */

public class JsonConvert<T>implements Converter<T>{

	private Gson gson=new Gson();
	private Class<T>tClass;
	private Type type;
	public JsonConvert(Class<T> tClass){
		this.tClass=tClass;
	}
	public JsonConvert(){

	}
	@Override
	public T convertResponse(Response response) throws Throwable {
		ResponseBody body = response.body();
		JsonReader jsonReader = new JsonReader(body.charStream());
		if (body == null) return null;
		if (tClass!=null) {
			return gson.fromJson(jsonReader,tClass);
		}else {
			if (type==null){
				type=getClass().getGenericSuperclass();
				ParameterizedType p=(ParameterizedType)type;
				tClass=(Class) p.getActualTypeArguments()[0];
				return gson.fromJson(jsonReader, tClass);
			}
		}
		return null;
	}
}
