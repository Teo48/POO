package com.tema1.utils;

import com.tema1.goods.Goods;

import java.util.Comparator;
/**
 * Class that implements a Comparator for Goods.
 * If the profit gained from the two Goods is equal then it returns the goods in descending by Ids.
 * Otherwise it returns the goods in descending order by Profit.
 * */
public final class GoodsComparator implements Comparator<Goods> {
    @Override
    public int compare(final Goods o1, final Goods o2) {
        if (o1.getProfit() == o2.getProfit()) {
            return o2.getId() - o1.getId();
        }

        return o2.getProfit() - o1.getProfit();
    }
}
