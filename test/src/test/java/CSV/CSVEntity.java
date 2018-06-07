package CSV;

import lombok.*;

import java.io.Serializable;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: zhaomingjie
 * @CreateDate: 2018/6/4 13:53
 * @Version: 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CSVEntity implements Serializable{
    private String member_id;
    private String request_url;
    private String request_addr;
    private String sessionId;
    private String traceId;
    private String hostname;

}
