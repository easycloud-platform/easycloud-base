package cn.catbar.easycloud.wechat.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration  //spring boot配置注解
@EnableSwagger2//启用swagger2功能注解
public class Swagger2Config {
    private static final Logger log = LoggerFactory.getLogger(Swagger2Config.class);
    /**
     * group :rest
     * 扫描注解了@ApiOperation的方法生成API接口文档
     * @return
     */
    @Bean
    public Docket RestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("TEAM")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {//接口的相关信息
        return new ApiInfoBuilder()
                .title("微信微服务平台")
                .description("微信公众号，小程序服务接口第三方对接平台。")
                .termsOfServiceUrl("")
                .contact(new Contact("liqian","https://blog.liqian.fun","51103942@qq.com"))
                .version("1.1.0")
                .build();
    }
}

