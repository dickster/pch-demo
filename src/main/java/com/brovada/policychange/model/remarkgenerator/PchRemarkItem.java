/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */

package com.brovada.policychange.model.remarkgenerator;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The PCH remark item model.
 * Created by CHARL228 on 11/04/2017.
 */
public class PchRemarkItem implements Comparable<PchRemarkItem> {

    private TreeMap<String, TreeSet<PchRemarkItem>> childMap = new TreeMap<>();
    private String remark;
    private int level = 0;

    /**
     * Constructor.
     *
     * @param pRemark the remark.
     * @param pLevel  the current level of the item.
     */
    public PchRemarkItem(final String pRemark,
                         int pLevel) {
        this.remark = pRemark;
        this.level = pLevel;
    }

    /**
     * Constructor.
     *
     * @param pLevel the current level of the item.
     */
    public PchRemarkItem(int pLevel) {
        this.level = pLevel;
    }

    /**
     * Add a child item.
     *
     * @param elementSegment The element segment as key.
     * @param newItem        The new remark item as value.
     *
     * @return The added new item.
     */
    public PchRemarkItem addChild(String elementSegment,
                                  PchRemarkItem newItem) {

        if (childMap.containsKey(elementSegment)) {
            TreeSet<PchRemarkItem> set = childMap.get(elementSegment);
            if (!set.contains(newItem)) {
                set.add(newItem);
            }
            return set.ceiling(newItem);
        }
        else {
            TreeSet<PchRemarkItem> set = new TreeSet<>();
            set.add(newItem);
            childMap.put(elementSegment, set);
            return newItem;
        }
    }

    /**
     * Check if contains a child by element segment name.
     *
     * @param elementSegment the element segment.
     *
     * @return true if it contains a child.
     */
    public boolean containChild(String elementSegment) {
        return this.childMap.containsKey(elementSegment);
    }

    /**
     * Get child map.
     *
     * @return the map.
     */
    public TreeMap<String, TreeSet<PchRemarkItem>> getChildMap() {
        return childMap;
    }

    /**
     * Get the remark.
     *
     * @return the remark String.
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Set a remark.
     *
     * @param remark the remark String.
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Get the current level.
     *
     * @return current level integer.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the current level.
     *
     * @param level current level integer.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(remark);
        sb.append("\n\n");
        Set<Map.Entry<String, TreeSet<PchRemarkItem>>> entries = childMap.entrySet();
        for (Map.Entry<String, TreeSet<PchRemarkItem>> entry : entries) {
            TreeSet<PchRemarkItem> value = entry.getValue();
            for (PchRemarkItem remarkItem : value) {
                for (int i = 0; i < level; i++) {
                    sb.append("\t");
                }
                sb.append(remarkItem.toString());
            }
        }
        return sb.toString();
    }

    @Override
    public int compareTo(PchRemarkItem o) {
        return o.getRemark().compareTo(this.getRemark());
    }
}
