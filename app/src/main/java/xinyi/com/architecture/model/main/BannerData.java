package xinyi.com.architecture.model.main;

import java.util.List;

/**
 * Created by wxy on 2017/9/30.
 */

public class BannerData {


	private List<BannerModelsBean> bannerModels;
	private List<OptionsModelsBean> optionsModels;
	private List<HeadNewsModelsBean> headNewsModels;

	public List<BannerModelsBean> getBannerModels() { return bannerModels;}

	public void setBannerModels(List<BannerModelsBean> bannerModels) { this.bannerModels = bannerModels;}

	public List<OptionsModelsBean> getOptionsModels() { return optionsModels;}

	public void setOptionsModels(List<OptionsModelsBean> optionsModels) { this.optionsModels = optionsModels;}

	public List<HeadNewsModelsBean> getHeadNewsModels() { return headNewsModels;}

	public void setHeadNewsModels(List<HeadNewsModelsBean> headNewsModels) { this.headNewsModels = headNewsModels;}

	public static class BannerModelsBean {
		/**
		 * id : 1
		 * imageUrl : 测试1
		 * description : https://g.cayica.com/Banner/2017/09/29/original/original_131511276130225495XHJ7.jpg
		 */

		private int id;
		private String imageUrl;
		private String description;

		public int getId() { return id;}

		public void setId(int id) { this.id = id;}

		public String getImageUrl() { return imageUrl;}

		public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl;}

		public String getDescription() { return description;}

		public void setDescription(String description) { this.description = description;}
	}

	public static class OptionsModelsBean {
		/**
		 * id : 1
		 * itemName : item1
		 * imageUrl : null
		 */

		private int id;
		private String itemName;
		private Object imageUrl;

		public int getId() { return id;}

		public void setId(int id) { this.id = id;}

		public String getItemName() { return itemName;}

		public void setItemName(String itemName) { this.itemName = itemName;}

		public Object getImageUrl() { return imageUrl;}

		public void setImageUrl(Object imageUrl) { this.imageUrl = imageUrl;}
	}

	public static class HeadNewsModelsBean {
		/**
		 * id : 1
		 * title : 华为电脑,给你一个不选苹果电脑的理由
		 * href : www.baidu.com
		 * imageUrl :
		 * type : 1
		 */

		private int id;
		private String title;
		private String href;
		private String imageUrl;
		private int type;

		public int getId() { return id;}

		public void setId(int id) { this.id = id;}

		public String getTitle() { return title;}

		public void setTitle(String title) { this.title = title;}

		public String getHref() { return href;}

		public void setHref(String href) { this.href = href;}

		public String getImageUrl() { return imageUrl;}

		public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl;}

		public int getType() { return type;}

		public void setType(int type) { this.type = type;}
	}
}
