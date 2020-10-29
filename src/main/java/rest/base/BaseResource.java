package rest.base;

import io.quarkus.arc.Arc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.base.BaseService;
import util.BaseUtil;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseResource<T> {

    private final BaseService<T> baseService;

    private final Class<T> tClass;

    @SuppressWarnings("unchecked")
    public BaseResource() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            tClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            tClass = (Class<T>) Object.class;
        }
        BeanManager beanManager = Arc.container().beanManager();
        Bean<BaseService<T>> bean = (Bean<BaseService<T>>) beanManager.resolve(beanManager.getBeans(BaseUtil.getBeanName(tClass.getName(), "Service")));
        baseService = (BaseService<T>) beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean));
    }

    @GetMapping
    public List<T> findAll() {
        return baseService.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable Long id) {
        return baseService.findById(id);
    }

    @PostMapping
    public T save(@RequestBody T t) {
        return baseService.save(t);
    }

}
