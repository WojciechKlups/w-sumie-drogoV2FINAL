package pl.sda.wsumiedrogo.repositories.custom;

import pl.sda.wsumiedrogo.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

    //https://www.baeldung.com/spring-data-jpa-query
    //https://www.baeldung.com/spring-data-composable-repositories
    //https://www.baeldung.com/hibernate-entitymanager

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int getMaxOrderNumber(String orderName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = criteriaBuilder.createQuery(Order.class);
        Root<Order> orderRoot = query.from(Order.class);

        Path<String> orderPath = orderRoot.get("orderNumber");
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.like(orderPath,orderName));

                query.select(orderRoot).where();

        return entityManager.createQuery(query).getResultList();
    }
}
