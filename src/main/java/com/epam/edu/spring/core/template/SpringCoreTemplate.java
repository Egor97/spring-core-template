package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {
	public static void main(String[] args) {
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(MainConfiguration.class);

		ColorFactory colorFactory = ctx.getBean(ColorFactory.class);
		ItemService itemService = ctx.getBean(ItemService.class);

		Item item = new Item(12, "shoes", 1200, colorFactory.getColor());
		Item item1 = new Item(1, "movie", 12, colorFactory.getColor());
		itemService.createItem(item);
		itemService.createItem(item1);
		System.out.println(itemService.getById(item.getId()));
		System.out.println(itemService.getById(item1.getId()));
	}
}
