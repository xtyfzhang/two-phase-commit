package twophasecommit;

import lombok.Data;

/**
 * 注册事务存在的服务信息.用户通知事务服务器提交还是回滚。
 */
@Data
public class ServerInfo {

    /**
     * 事务ID
     */
    private Long transactionId;

    /**
     * 服务的名称
     */
    private String serverName;

    /**
     * 服务的IP
     */
    private String serverIp;

    /**
     * 服务端口
     */
    private String serverPort;

    /**
     * 服务路径地址
     */
    private String serverPath;
}
