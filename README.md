# spb-blog-user

一、查看mysql数据表的表结构

desc table_name;

二、service注解

1、父service接口

    public interface UserService {...}

2、Impl实现接口，要添加@service注解

    @Service
    public class UserServiceImpl implements UserService {...}

3、在controller中的引用，还是父接口

    @Controller
    public class MainController {

    @Autowired
    private UserService userService;
    ...
    }
    
注意1：@service是加在子类上

注意2：在controller中，@Autowired的是父接口


===2019029===

一、Bean Validation

注解 @NotEmpty,@Email都是hibernate提供的注解

validation与 springboot 结合

1. bean 中添加标签

2. Controller中开启验证

3. resource 下新建错误信息配置文件

4. 自定义异常处理器，捕获错误信息

参考url:https://blog.csdn.net/u012373815/article/details/72049796

二、StringUtils

包目录：import org.apache.commons.lang3.StringUtils;

apache.commons.lang3 主要用于字符串的处理

StringUtils中常用的一些方法：1.isEmpty、isNotEmpty、isBlank、isNotBlank

StringUtils.join 用来连接字符串
