
<#import "common.ftl" as c>

<@c.page>
<#include "navbar.ftl">
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <#if cart?has_content>
                    <#list cart as cart>
                    <th scope="row">${cart?index}</th>
                    <td>${cart.getKey().name}</td>
                    <td>${cart.getKey().getPrice()}</td>
                    <td>${cart.getValue()}</td>
            </tr>

                    </#list>

                </#if>

        </tbody>
    </table>
    <#if total?has_content>
        <div> Total Price is ${total}</div>
        <#else>
            <div> Total Price is ${0.00}</div>
    </#if>

</div>
</@c.page>
