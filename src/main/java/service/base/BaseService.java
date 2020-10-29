package service.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class BaseService<T> {

    @Autowired
    public EntityManager entityManager;

    private final Class<T> tClass;

    @SuppressWarnings("unchecked")
    protected BaseService() {
        Type type = this.getClass().getSuperclass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            tClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            tClass = (Class<T>) Object.class;
        }
    }

    @Transactional
    public T findById(Long id) {
        return entityManager.createQuery("FROM " + tClass.getName() + " WHERE id=" + id, tClass).getSingleResult();
    }

    @Transactional
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + tClass.getName() + " WHERE deleted=0", tClass).getResultList();
    }

    @Transactional
    public T save(T t) {
        return entityManager.merge(t);
    }

}
