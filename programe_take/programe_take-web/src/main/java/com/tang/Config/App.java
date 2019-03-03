package com.tang.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 * @create 2019-01-30 16:26
 */
@Configuration
public class App implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        搜索页面
        registry.addViewController("/search_Result").setViewName("search_Result.html");
//         主页面
        registry.addViewController("/").setViewName("main.html");
//        登录
        registry.addViewController("/login").setViewName("login.html");
//        注册
        registry.addViewController("/register").setViewName("register.html");
//        公告页
        registry.addViewController("/notice").setViewName("notice.html");
//        发帖
        registry.addViewController("/sendArticle").setViewName("sendArticle.html");
//        文章详情页
        registry.addViewController("/aticle/detail").setViewName("/article_details.html");

//        分类--->前端开发页面
        registry.addViewController("/front").setViewName("/category/front_end_Development.html");
        registry.addViewController("/backed").setViewName("/category/backed_Development.html");
        registry.addViewController("/game").setViewName("/category/game_Development.html");
        registry.addViewController("/ai").setViewName("/category/AI_Development.html");


//        用户后台
        registry.addViewController("/user/").setViewName("/Backstage/User/user.html");
//        admin后台
        registry.addViewController("/admin/").setViewName("/Backstage/Admin/admin_index.html");
//        admin 登录
        registry.addViewController("/admin/login_").setViewName("/Backstage/login.html");
//        admin 审核处理
        registry.addViewController("/admin/audit_article").setViewName("/Backstage/Admin/survey_article.html");
//        admin 用户管理
        registry.addViewController("/admin/user_make").setViewName("/Backstage/Admin/user_make.html");
//        admin 文章管理
        registry.addViewController("/admin/article_make").setViewName("/Backstage/Admin/article_make.html");
//        admin 热门推荐
        registry.addViewController("/admin/hot_recommend").setViewName("/Backstage/Admin/hot_recommend.html");
//        dmin  置顶管理
        registry.addViewController("/admin/top_recommend").setViewName("/Backstage/Admin/top_recommend.html");
//        admin 评论管理
        registry.addViewController("/admin/comment_make").setViewName("/Backstage/Admin/comment_make.html");
//        admin 公告管理
        registry.addViewController("/admin/notic").setViewName("/Backstage/Admin/admin_notice.html");
//        admin 统计
        registry.addViewController("/admin/sum").setViewName("/Backstage/Admin/sum.html");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        ArrayList<String> list = new ArrayList<>();
//
//        list.add("/login");
//        list.add("/register");
//        list.add("/main");
//        list.add("/front");
//
//        registry.addInterceptor(new LoginInterpect()).excludePathPatterns(list);
//    }
}
