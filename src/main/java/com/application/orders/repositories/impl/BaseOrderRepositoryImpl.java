package com.application.orders.repositories.impl;

import com.application.orders.criterias.OrderSearchCriteria;
import com.application.orders.documents.Order;
import com.application.orders.repositories.BaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseOrderRepositoryImpl implements BaseOrderRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

//    @Query("""
//        {
//            $or: [
//                {'title': { $regex: '.*?0.*', $options: 'i' }},
//                {'description': { $regex: '.*?0.*', $options: 'i' }},
//                {'products.name': { $regex: '.*?0.*', $options: 'i' }}
//            ]
//        }
//        """)
    @Override
    public List<Order> findAllByCriteria(OrderSearchCriteria criteria) {
        Query query = new Query();

        if (criteria.archived() != null) {
            query.addCriteria(Criteria.where("archived").is(criteria.archived()));
        }

        if (criteria.status() != null) {
            query.addCriteria(Criteria.where("status").is(criteria.status()));
        }

        if (criteria.query() != null) {
            String q = criteria.query();

            query.addCriteria(
                    new Criteria().orOperator(
                            Criteria.where("title").regex(q, "i"),
                            Criteria.where("description").regex(q, "i"),
                            Criteria.where("products").elemMatch(Criteria.where("name").regex(q, "i"))
                    )
            );
        }

        return mongoTemplate.find(query, Order.class);
    }
}
