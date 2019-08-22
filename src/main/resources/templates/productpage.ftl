
<#import "parts/common.ftl" as c>

<@c.page>
<#include "parts/navbar.ftl">
<div class="container">
    <table class="table table-borderless">
        <tbody>
            <tr>
                <#if product?has_content>
                    <#list product as product>
                    <td>
                        <div class="card" style="width: 18rem;">
                            <div class="card-body">
                                <h5 class="card-title">${product.getName()}</h5>
                                <p class="card-text">${product.getPrice()} $</p>
                                <form class="form-inline"  action="/productpage/addproduct/${product.getId()}">
                                    <#if product.getQuantity()==0>
                                        <div class="alert-light">
                                            out of stock
                                        </div>
                                        <#else >
                                            <input type="number" name="count" value="1" min="1" max="${product.getQuantity()}"/>
                                            <button type="submit" class="btn btn-info btn-sm">Buy</button>
                                    </#if>
                                </form>
                            </div>
                        </div>
                    </td>
                    </#list>
                </#if>
            </tr>
        </tbody>
    </table>
</div>
</@c.page>
