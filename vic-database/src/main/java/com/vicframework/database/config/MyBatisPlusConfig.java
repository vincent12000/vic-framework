package com.vicframework.database.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.vicframework.database.common.VicMyBatisPlusProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
//@MapperScan("com.hsbc.huatou.admin.dao")
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class MyBatisPlusConfig {

    private VicMyBatisPlusProperties myBatisPlusProperties;

//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        log.info("paginationInterceptor");
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
//        // paginationInterceptor.setOverflow(false);
//        // 设置最大单页限制数量，默认 500 条，-1 不受限制
//        paginationInterceptor.setLimit(50);
//        return paginationInterceptor;
//    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        log.info("mapperScannerConfigurer");
        log.info(myBatisPlusProperties.getMapperScanPath());
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage(myBatisPlusProperties.getMapperScanPath());
        return scannerConfigurer;
    }

}
