package ae.spring.bean.five;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(final ConfigurableListableBeanFactory arg0)
			throws BeansException {
		System.out
				.println("Il container ha caricato le definizioni dei bean ma ancora non sono stati istanziati");
	}

}
