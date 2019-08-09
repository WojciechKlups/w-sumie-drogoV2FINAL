package pl.sda.wsumiedrogo.repositories.custom;


import pl.sda.wsumiedrogo.model.Order;

public interface OrderRepositoryCustom {

    int getMaxOrderNumber(String orderName);
}
