package com.ambry.common.model.request;

import java.util.List;
import java.util.Map;

public record OrderCreateRequest(Long userId, String receiverName, String receiverPhone, String receiverRegionCode, String receiverRegionName, String receiverAddress, List<OrderGoodsRequest> goodsList) {
    public record OrderGoodsRequest(Long goodsId, Integer quantity, Map<String, String> customOptions) {
    }
}
