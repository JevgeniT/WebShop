<#import "parts/common.ftl" as c>
<@c.page>
    <#include "parts/navbar.ftl">
<div class="container">
    <h2 class="text-center font-weight-light">Account details</h2>
    <hr>
    <div class="row">
        <div class="col-3">
            <div class="ibox">
                <div class="ibox-content">
                    <h5 >Customer</h5>
                    <hr>
                    <div>Username: ${userDetail.getUsername()}</div>
                    <div>Role: ${userDetail.getRoles()?join(", ")}</div>
                    <div>Available balance: $${userDetail.getBalance()}</div>
                </div>
            </div>
        </div>
        <hr>
        <div class="col">
            <div class="ibox">
                <div class="ibox-content">
            <h5>Order History</h5>
            <table class="table table-striped table-borderless table-sm display compact dataTable">
                <thead>
                <tr>
                    <th scope="col">#id</th>
                    <th scope="col">Order date</th>
                    <th scope="col">Total price</th>
                    <th scope="col">Status</th>
                    <th scope="col">Ship date</th>
                </tr>
                </thead>
                <tbody>
                    <#if userDetail.getOrders()?has_content>
                        <#list userDetail.getOrders() as orders>
                            <tr>
                            <td>${orders.getId()}</td>
                            <td>${orders.getOrderDate()}</td>
                            <td>${orders.getTotalPrice()}</td>
                            <td>${orders.getStatus()}</td>
                            <td><#if orders.getShipDate()??>${orders.getShipDate()}<#else>Pending</#if></td>
                            </tr>
                        </#list>
                    </#if>
                </tbody>
            </table>
        </div>
    </div>
        </div>
    </div>
</div>
</@c.page>

