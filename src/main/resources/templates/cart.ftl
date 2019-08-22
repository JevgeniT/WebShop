
<#import "parts/common.ftl" as c>

<@c.page>
<#include "parts/navbar.ftl">
<div class="container">
    <table class="table table-hover table-condensed">
        <thead>
        <tr>
            <th style="width:70%">Product</th>
            <th style="width:10%">Unit Price</th>
            <th style="width:8%">Quantity</th>
            <th style="width:22%" class="text-center">Subtotal</th>
            <th style="width:10%"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <#if cart?has_content>
                <#list cart as cart>
        <tr>
            <td data-th="Product">
                <div class="row">
                    <div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
                    <div class="col-sm-10">
                        <h4 class="nomargin">${cart.getKey().name}</h4>
                        <p>text</p>
                    </div>
                </div>
            </td>
            <td data-th="Unit Price">${cart.getKey().getPrice()} $</td>
            <td data-th="Quantity">${cart.getValue()}</td>
            <td data-th="Subtotal" class="text-center">${cart.getKey().getPrice() * cart.getValue()} $</td>
            <td class="actions">
                <button class="btn btn-danger btn-sm"><a href="/cart/removeProduct/${cart.getKey().getId()}" class="fa fa-trash-o"></a></button>
            </td>
        </tr>

        </#list>
        </#if>
        </tbody>
            <tfoot>
            <tr>
                <td><a href="/productpage" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
                <td colspan="2" class="hidden-xs"></td>
                <#if total?has_content>
                    <td class="hidden-xs text-center"><strong>Total ${total} $</strong></td>
                <#else>
                    <td class="hidden-xs text-center"><strong>Total ${0.00} $</strong></td>
                </#if>
                <td><a href="/productpage/checkout" class="btn btn-success btn-block">Checkout</a></td>
            </tr>
            </tfoot>
    </table>

    <#if message?has_content>
        <div class="alert alert-danger alert-dismissible fade show">
            <strong>${message}!</strong>
            <button type="button" class="close" data-dismiss="alert">&times;</button>
        </div>
    </#if>
</div>

</@c.page>
