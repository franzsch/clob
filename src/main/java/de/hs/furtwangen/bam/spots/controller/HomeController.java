package de.hs.furtwangen.bam.spots.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Resource(name = "gitProperties")
	private Properties gitProperties;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "/app/index.html";
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	@ResponseBody
	public List<PropertyBean> git() {
		List<PropertyBean> listPropertyBean = new ArrayList<>();
		for (String gitKey : gitProperties.stringPropertyNames()) {
			PropertyBean propertyBean = new PropertyBean();
			propertyBean.setKey(gitKey);
			propertyBean.setValue(gitProperties.getProperty(gitKey));
			listPropertyBean.add(propertyBean);
		}
		return listPropertyBean;
	}

	class PropertyBean {
		String key;
		String value;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

}