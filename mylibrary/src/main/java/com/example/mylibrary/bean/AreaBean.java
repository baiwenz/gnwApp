package com.example.mylibrary.bean;

import java.util.List;

public class AreaBean implements Comparable<AreaBean>{
    public static final int ITEM_TYPE_PARENT = 0;
    public static final int ITEM_TYPE_CHILD = 1;

    private String uuid;

    private int type;// 显示类型
    private String name;
    private String path;// 路径
    private int treeDepth = 0;// 路径的深度

    private List<AreaBean> children;

    private boolean expand;// 是否展开

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AreaBean> getChildren() {
        return children;
    }

    public void setChildren(List<AreaBean> children) {
        this.children = children;
    }

    public AreaBean(int type, String name, String path, String uuid,
                    int treeDepth, List<AreaBean> children) {
        super();
        this.type = type;
        this.name = name;
        this.uuid = uuid;
        this.path = path;
        this.treeDepth = treeDepth;
        this.children = children;
    }

    public AreaBean() {

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTreeDepth() {
        return treeDepth;
    }

    public void setTreeDepth(int treeDepth) {
        this.treeDepth = treeDepth;
    }
    @Override
    public int compareTo(AreaBean o) {
        return 0;
    }
}
