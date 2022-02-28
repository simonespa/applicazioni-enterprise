package ae.spring.bean.five;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	private final class DescribeMethodWrapper implements InvocationHandler {

		private final Object originalBean;

		private DescribeMethodWrapper(final Object bean) {
			originalBean = bean;
		}

		@Override
		public Object invoke(final Object proxy, final Method method, final Object[] args)
				throws Throwable {
			if (method.getName().equals("describe")) {
				final String originalValue = (String) method.invoke(originalBean, args);
				return "[" + originalValue + "]";
			}
			return method.invoke(originalBean, args);
		}
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, final String beanName)
			throws BeansException {
		if (bean instanceof UserDescriber) {
			final Object proxied = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
					new Class<?>[] { UserDescriber.class }, new DescribeMethodWrapper(bean));
			System.out.println(String.format("Bean '%s' wrapped as: %s (%s)", beanName,
					proxied.toString(), proxied.getClass()));
			return proxied;
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(final Object bean, final String beanName)
			throws BeansException {
		System.out.println(String.format("Bean '%s' created: %s (%s)", beanName, bean.toString(),
				bean.getClass()));
		return bean;
	}
}
