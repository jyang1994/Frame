<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 左侧菜单栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">


        <!-- 菜单 -->
        <ul class="sidebar-menu">
            <li class="${param.menu == 'home' ? 'active' : ''}"><a href="/home"><i class="fa fa-home"></i> <span>首页</span></a></li>
            <shiro:hasRole name="ticket">
            <li class="header">下发管理</li>
                <shiro:hasPermission name="ticket:home">
                 <li class="${param.menu == 'ticket_in' ? 'active' : ''}"><a href="/finance/ticket/in/home"><i class="fa fa-circle-o"></i> <span>入票管理</span></a></li>
                </shiro:hasPermission>

                <li class="${param.menu == 'ticket_out' ? 'active' : ''}"><a href="/finance/ticket/out/home"><i class="fa fa-circle-o"></i> <span>年票下发</span></a></li>
                <li class="${param.menu == 'ticket_invalid' ? 'active' : ''}"><a href="/finance/ticket/all"><i class="fa fa-circle-o"></i> <span>年票作废</span></a></li>

                <li class="header">结算管理</li>
                <li class="${param.menu == 'ticket_pay' ? 'active' : ''}"><a href="/finance/ticket/out/pay"><i class="fa fa-circle-o"></i> <span>缴费管理</span></a></li>

            </shiro:hasRole>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>