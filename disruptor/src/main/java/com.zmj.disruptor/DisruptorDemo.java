package com.zmj.disruptor;

import com.lmax.disruptor.*;

import java.text.DecimalFormat;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: zhaomingjie
 * @CreateDate: 2018/5/31 21:06
 * @Version: 1.0
 */
public class DisruptorDemo {
    //待生产的对象个数
    final long objCount = 1000000;
    final long bufSize;//缓冲区大小
    {
        bufSize = getRingBufferSize(objCount);
    }

    /**
     * 获取RingBuffer的缓冲区大小（2的幂次！加速计算）
     * @param num
     * @return
     */
    private static long getRingBufferSize(long num)
    {
        long s = 2;
        while ( s < num )
        {
            s <<= 1;
        }
        return s;
    }

    /**
     * 使用LinkedBlockingQueue测试
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void testBlocingQueue() throws Exception
    {
        final LinkedBlockingQueue<TestObj> queue = new LinkedBlockingQueue();
        Thread producer = new Thread(()-> {//生产者
                try{
                    for ( long i=1;i<=objCount;i++ )
                    {
                        queue.put(new TestObj(i));//生产
                    }
                }catch ( InterruptedException e ){
                }
        });
        Thread consumer = new Thread(()->{//消费者
                try{
                    TestObj readObj = null;
                    for ( long i=1;i<=objCount;i++ )
                    {
                        readObj = queue.take();//消费
                        //DoSomethingAbout(readObj);
                    }
                }catch ( InterruptedException e ){

                }
        });

        long timeStart = System.currentTimeMillis();//统计时间
        producer.start();
        consumer.start();
        consumer.join();
        producer.join();
        long timeEnd = System.currentTimeMillis();
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        System.out.println((timeEnd - timeStart) + "/" + df.format(objCount) +
                " = " + df.format(objCount/(timeEnd - timeStart)*1000) );
    }

    /**
     * 使用RingBuffer测试
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void testRingBuffer() throws Exception
    {
        //创建一个单生产者的RingBuffer，EventFactory是填充缓冲区的对象工厂
        //            YieldingWaitStrategy等"等待策略"指出消费者等待数据变得可用前的策略
        final RingBuffer<TestObj> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<TestObj>() {
            @Override
            public TestObj newInstance() {
                return new TestObj(0);
            }
        } , (int)bufSize, new YieldingWaitStrategy());

        //创建消费者指针
        final SequenceBarrier barrier = ringBuffer.newBarrier();

        Thread producer = new Thread(()-> {//生产者
                for ( long i=1;i<=objCount;i++ )
                {
                    long index = ringBuffer.next();//申请下一个缓冲区Slot
                    ringBuffer.get(index).setValue(i);//对申请到的Slot赋值
                    ringBuffer.publish(index);//发布，然后消费者可以读到
                }

        });
        Thread consumer = new Thread(()-> {//消费者
                TestObj readObj = null;
                int readCount = 0;
                long readIndex = Sequencer.INITIAL_CURSOR_VALUE;
                while ( readCount < objCount )//读取objCount个元素后结束
                {
                    try{
                        long nextIndex = readIndex + 1;//当前读取到的指针+1，即下一个该读的位置
                        long availableIndex = barrier.waitFor(nextIndex);//等待直到上面的位置可读取
                        while ( nextIndex <= availableIndex )//从下一个可读位置到目前能读到的位置(Batch!)
                        {
                            readObj = ringBuffer.get(nextIndex);//获得Buffer中的对象
                            //DoSomethingAbout(readObj);
                            readCount++;
                            nextIndex ++;
                        }
                        readIndex = availableIndex;//刷新当前读取到的位置
                    }catch ( Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
        });

        long timeStart = System.currentTimeMillis();//统计时间
        producer.start();
        consumer.start();
        consumer.join();
        producer.join();
        long timeEnd = System.currentTimeMillis();
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        System.out.println((timeEnd - timeStart) + "/" + df.format(objCount) +
                " = " + df.format(objCount/(timeEnd - timeStart)*1000) );

    }

    public static void main(String[] args) throws Exception {
        DisruptorDemo ins = new DisruptorDemo();
        //执行测试
        ins.testBlocingQueue();
        ins.testRingBuffer();
    }
}
