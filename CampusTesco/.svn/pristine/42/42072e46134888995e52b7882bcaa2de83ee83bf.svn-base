package com.example.commonlibrary.base;

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 *  类名:BaseEntity.java
 * 描述:实体模型基类
 * 作用:各实体模型从该类继承
 */
public abstract class BaseEntity implements Serializable{
    /**
     * 函数名:toString
     * 作用:toString
     * 参数：void
     * 返回值:String
     */

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        Class c = getClass();
        buffer.append(c.getName());
        buffer.append("[");
        Field fields[] = c.getDeclaredFields();
        try {
            AccessibleObject.setAccessible(fields,true);
            for(int i=0;i<fields.length;i++){
                if(i!=0){
                    buffer.append(",");
                }
                String name = fields[i].getName();
                Object value = fields[i].get(this);
                buffer.append(name+"="+value);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        buffer.append("]");
        return buffer.toString();
    }
}
