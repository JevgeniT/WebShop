<#import "navadmin.ftl" as a>
<@a.page>
    <div class="ibox">
        <div class="ibox-content">
        <div class="col" >
            <h5>Orders</h5>
            <table id="orderTable" class="table table-striped table-borderless table-sm display compact dataTable">
                <thead>
                <tr>
                    <th class="th-sm">#id</th>
                    <th class="th-sm">Order date</th>
                    <th class="th-sm">Order Price</th>
                    <th class="th-sm">Order Status</th>
                    <th class="th-sm">Shipping date</th>
                    <th class="th-sm"></th>
                </tr>
                </thead>
                <tbody>
                <#if orders?has_content>
                    <#list orders as order>
                        <tr id="${order.getId()}">
                            <td>${order.getId()}</td>
                            <td>${order.getOrderDate()}</td>
                            <td>${order.getTotalPrice()} $</td>
                            <td>${order.getStatus()?cap_first}</td>
                            <td><#if order.getShipDate()??> ${order.getOrderDate()}</td>
                                <td><button class="btn btn-outline-success waves-effect btn-sm" disabled ><span class="glyphicon glyphicon-ok"></span>Shipped</button></td>
                                <#else>
                                    <td><a id="ship" class="btn btn-outline-success waves-effect btn-sm">Ship</a></td>
                                </#if>
                        </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
    </div>
    </div>
    <div id="alert" class="alert fade">
        <button type="button" class="close">&times;</button>
        <h4 class="alert-heading" style="text-align: center"></h4>
    </div>

</@a.page>
