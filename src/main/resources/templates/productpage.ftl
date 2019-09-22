<#import "parts/common.ftl" as c>
<@c.page>
<#include "parts/navbar.ftl">
<div class="container" >
    <div class="card-deck">
    <#if product?has_content>
        <#list product as product>
        <div class="col-md-4 mt-4">
             <div class="card order-card" >
                <div class="card-block">
                    <div class="product-imitation">
                        [ INFO ]
                    </div>
                    <div class="product-desc">
                        <span class="product-price">
                            $${product.getPrice()}
                        </span>
                    </div>
                    <h5 class="card-title">${product.getName()}</h5>
                        <p class="small">Lorem ipsum dolor sit amet.....</p>
                        <#if product.getQuantity()==0>
                            <div class="alert-light">out of stock</div>
                            <#else >
                                <label class="form-inline">
                                    <button type="button" class="btn btn-primary btn-sm btn-buy" id="${product.getId()}"><span class="fa fa-shopping-cart"></span>Buy</button>
                                </label>
                        </#if>
                </div>
            </div>
        </div>
        </#list>
    </#if>
</div>
    <div id="alert" class="alert fade">
        <button type="button" class="close">&times;</button>
        <h4 class="alert-heading" style="text-align: center"></h4>
    </div>
</div>
</@c.page>
