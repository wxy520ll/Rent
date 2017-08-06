package com.xinyi_tech.commonlibs;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Stack;


/**
 * 
 * ClassName: AppManager <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015-5-21 上午11:21:38 <br/>
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 * 
 * @author hao
 * @version
 * @since JDK 1.6
 */
final public class AppManager
{
	private static Stack<AppCompatActivity> activityStack;
	private static final AppManager instance = new AppManager();
	private static ArrayList<AppCompatActivity> activityList;
	private AppManager()
	{
	}

	public static AppManager create()
	{
		return instance;
	}

	/**
	 * 获取当前Activity栈中元素个数
	 */
	public int getCount()
	{
		return activityStack.size();
	}

	/**
	 * 添加Activity到栈
	 */
	public void addActivity(AppCompatActivity activity)
	{
		if(activityStack == null)
		{
			activityStack = new Stack<AppCompatActivity>();
		}
		activityStack.add(activity);
		
		if(activityList == null)
		{
			activityList = new ArrayList<AppCompatActivity>();
		}
		activityList.add(activity);
	}

	/**
	 * 获取当前Activity（栈顶Activity）
	 */
	public Activity topActivity()
	{
		if(activityStack == null)
		{
			throw new NullPointerException(
					"Activity stack is Null,your Activity must extend YHActivity");
		}
		if(activityStack.isEmpty())
		{
			return null;
		}
		AppCompatActivity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 获取当前Activity（栈顶Activity） 没有找到则返回null
	 */
	public Activity findActivity(Class<?> cls)
	{
		AppCompatActivity activity = null;
		for (AppCompatActivity aty : activityStack)
		{
			if(aty.getClass().equals(cls))
			{
				activity = aty;
				break;
			}
		}
		return activity;
	}

	/**
	 * 结束当前Activity（栈顶Activity）
	 */
	public void finishActivity()
	{
		AppCompatActivity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 结束指定的Activity(重载)
	 */
	public void finishActivity(Activity activity)
	{
		if(activityStack!=null&&activity != null)
		{
			activityStack.remove(activity);
			activity.finish();//此处不用finish
			activity = null;
		}
	}

	/**
	 * 结束指定的Activity(重载)
	 */
	public void finishActivity(Class<?> cls)
	{
		for (AppCompatActivity activity : activityStack)
		{
			if(activity.getClass().equals(cls))
			{
				finishActivity(activity);
			}
		}
	}

	/**
	 * 结束指定的Activity list
	 */
	public void finishActivityList(Class<?> cls)
	{
		for (AppCompatActivity activity : activityList)
		{
			if(activity.getClass().equals(cls))
			{
				if(activity != null)
				{
					//activityList.remove(activity);
					activity.finish();
					activity = null;
				}
			}
		}
	}
	
	
	/**
	 * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
	 * 
	 * @param cls
	 */
	public void finishOthersActivity(Class<?> cls)
	{
		for (AppCompatActivity activity : activityStack)
		{
			if(!(activity.getClass().equals(cls)))
			{
				finishActivity(activity);
			}
		}
	}

	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity()
	{
		for (int i = 0, size = activityStack.size(); i < size; i++)
		{
			if(null != activityStack.get(i))
			{
				activityStack.get(i).finish();
			}
		}
		// MyApplication.db.close();
		activityStack.clear();
	}

	/**
	 * 结束到剩下MainActivity
	 */
	public void finishAllActivityForMain()
	{
		for (int i = 0, size = activityStack.size(); i < size; i++)
		{
			if(i == 0)
			{
				continue;
			}
			if(null != activityStack.get(i))
			{
				activityStack.get(i).finish();
			}
		}
	}
	

	/**
	 * 应用程序退出
	 * 
	 */
	public void AppExit(Context context)
	{
		try
		{
			finishAllActivity();
			Runtime.getRuntime().exit(0);
		}
		catch (Exception e)
		{
			Runtime.getRuntime().exit(-1);
		}
	}
}