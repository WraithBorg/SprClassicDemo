package com.spr.util;

import java.util.ArrayList;
import java.util.List;

public class SprLock implements AutoCloseable {
    private List<String> lockedIds = new ArrayList<>();

    /**
     * 
     * @param userName 当前操作人
     * @param ids 加锁id列表
     */
    public SprLock(String userName, String... ids) {
        this.lock(userName, ids);
    }

    private void lock(String userName, String... ids) {
        if (CustomUtil.isNotEmpty(ids)) {
            for (String billId : ids) {
                if (SprLockCache.put(billId, userName) == null) {
                    lockedIds.add(billId);
                } else {
                    throw new BusinessException(SprLockCache.get(billId) + " 正在操作，请稍后重试!");
                }
            }
        }
    }

    @Override
    public void close() {
        if (CustomUtil.isNotEmpty(lockedIds)) {
            for (String billId : lockedIds) {
                SprLockCache.remove(billId);
            }
        }
    }
}
