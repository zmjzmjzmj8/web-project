import net.sf.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: zhaomingjie
 * @CreateDate: 2018/6/4 13:35
 * @Version: 1.0
 */
public class TestReadCSV {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("F://操作日志.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            List<CSVEntity> result = new ArrayList<CSVEntity>();
            //读取文件，并装填存放
            while ((line = reader.readLine()) != null) {
                CSVEntity csvEntity = new CSVEntity();
                String item[] = line
                        .replaceAll("[{}\"]", "").split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                csvEntity.setMember_id(item[0]);
                csvEntity.setRequest_url(item[1]);
                csvEntity.setRequest_addr(item[2]);
                csvEntity.setSessionId(item[3].split(":")[1]);
                csvEntity.setTraceId(item[4].split(":")[1]);
                csvEntity.setHostname(item[5].split(":")[1]);
                result.add(csvEntity);
            }
            int all = result.size();
            //System.out.println(result);

            //根据ip分组
            Map<String, List<CSVEntity>> collect = result.stream()
                    .collect(Collectors.groupingBy(CSVEntity::getRequest_addr));
            int ipAll = collect.size();
            //System.out.println(collect);
            final int[] sum = {0};
            List<String> errorIP = new ArrayList<>();
            collect.forEach((s, csvEntities) -> {
                //再更具hostname分组，如果同一IP有多个hostname，则是错误ip
                Map<String, List<CSVEntity>> collect1 = csvEntities.stream().collect(Collectors.groupingBy(CSVEntity::getHostname));
                if (collect1.size() > 1) {
                    System.out.println(collect1);
                    sum[0]++;
                    errorIP.add(s);
                }
            });
            //打印错误ip数组
            System.out.println(errorIP);
            System.out.println("all = " + all + " ipAll = " + ipAll + " sum = " + sum[0]);
            // 创建一个数值格式化对象
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String p = numberFormat.format((float) sum[0] / (float) ipAll * 100);
            System.out.println("IP为单位百分比为 : " + p + "%");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
