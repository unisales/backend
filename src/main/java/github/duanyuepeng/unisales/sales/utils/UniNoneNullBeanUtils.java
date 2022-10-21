package github.duanyuepeng.unisales.sales.utils;

import org.apache.commons.beanutils.BeanUtilsBean2;

import java.lang.reflect.InvocationTargetException;

public class UniNoneNullBeanUtils {
  private static final UniNonNullBeanUtilsBean bean = new UniNonNullBeanUtilsBean();

  public static void copyProperties(final Object dest, final Object orig) {
    UniRunnableUtils.runSafely(() -> bean.copyProperties(dest, orig));
  }
}

class UniNonNullBeanUtilsBean extends BeanUtilsBean2 {
  @Override
  public void copyProperty(final Object bean, String name, Object value)
    throws InvocationTargetException, IllegalAccessException {
    if (value != null) {
      super.copyProperty(bean, name, value);
    }
  }
}
