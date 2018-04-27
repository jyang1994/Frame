<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 左侧菜单栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">


        <!-- 菜单 -->
        <ul class="sidebar-menu">
            <li class="${param.menu == 'home' ? 'active' : ''}"><a href="/home"><i class="fa fa-home"></i> <span>首页</span></a></li>
            <li class="header">销售管理</li>

                <li class="${param.menu == 'sales_list' ? 'active' : ''}"><a href="/sale/list"><i class="fa fa-circle-o"></i> <span>年票销售</span></a></li>
                <li class="${param.menu == 'sales_pay' ? 'active' : ''}"><a href="/sale/pay"><i class="fa fa-circle-o"></i> <span>年票缴费</span></a></li>
                 <li class="${param.menu == 'ticket_lose' ? 'active' : ''}"><a href="/sale/ticket/lose"><i class="fa fa-circle-o"></i> <span>年票挂失</span></a></li>
            <li class="${param.menu == 'sale_tongji' ? 'active' : ''}"><a href="/sale/tongji"><i class="fa fa-circle-o"></i> <span>销售统计</span></a></li>

        </ul>
    </section>

</aside>