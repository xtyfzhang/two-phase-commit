package twophasecommit.mapper;

import org.apache.ibatis.annotations.Param;

public interface ClientDemoMapper {

    /**
     * 修改信息
     * @return
     */
    int updateTest(@Param("name") String name,@Param("id") String id);
}
