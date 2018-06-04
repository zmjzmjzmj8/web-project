package com.zmj.disruptor;

/**
 * 简单对象：缓冲区中的元素，里面只有一个value，提供setValue
 *
 * @Description: java类作用描述
 * @Author: zhaomingjie
 * @CreateDate: 2018/5/31 21:08
 * @Version: 1.0
 */
public class TestObj {

    public long value;

    public TestObj(long value)
    {
        this.value = value;
    }

    public void setValue(long value)
    {
        this.value = value;
    }

}