<#import "parts/common.ftl" as c>
<@c.page>
<#include "parts/navbar.ftl">
    <div class="container">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-md-9">
                    <div class="ibox">
                        <div class="ibox-title">
                            <span class="pull-right">(<strong class="cartSize"></strong>)items</span>
                            <h5>Items in your cart</h5>
                        </div>
                        <#if cart?has_content>
                            <#list cart as cart>
                                <div id="cartContainer">
                                <div class="ibox-content" id="rowId${cart.getKey().getId()}">
                                    <div class="table-responsive">
                                        <table class="table shoping-cart-table">
                                            <tbody>
                                            <tr>
                                                <td>
                                                    <div class="cart-product-imitation"></div>
                                                </td>
                                                <td class="desc">
                                                    <h3><a class="text-navy">${cart.getKey().name}</a></h3>
                                                    <p class="small">
                                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                                                        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                                    </p>
                                                    <div class="m-t-sm" id="${cart.getKey().getId()}">
                                                        <a class="text-muted" id="remove">
                                                            <i class="fa fa-trash"></i> Remove item
                                                        </a> |
                                                        <a class="text-muted" id="refresh">
                                                            <i class="fa fa-refresh"></i> Refresh item
                                                        </a>
                                                    </div>
                                                </td>
                                                <td>$${cart.getKey().getPrice()}</td>
                                                <td >
                                                    <label>
                                                        <input type="number" name="cartCount" value="${cart.getValue()}" min="1" max="${cart.getKey().getQuantity()}" onkeydown="return false"/>
                                                    </label>
                                                </td>
                                                <td>
                                                    <h4>$${cart.getKey().getPrice() * cart.getValue()}</h4>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                </div>
                            </#list>
                        </#if>
                        <div class="ibox-content">
                            <a href="/productpage" class="btn btn-white" ><i class="fa fa-arrow-left"></i> Continue shopping</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3" id="cartBox">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>Cart Summary</h5>
                        </div>
                        <div class="ibox-content">
                            <span>Total</span>
                            <h2 class="font-bold">
                                $<span id="cartTotal">${total}</span>
                            </h2>
                            <hr>
                            <div class="m-t-sm">
                                <div class="btn-group">
                                    <#if total !=0 >
                                    <a href="/cart/checkout" class="btn btn-primary btn-sm" ><i class="fa fa-shopping-cart"></i>Checkout</a>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="alert" class="alert fade">
                <button type="button" class="close">&times;</button>
                <h4 class="alert-heading" style="text-align: center"></h4>
                    <p id="response"><#if message??>${message}</#if></p>
            </div>
        </div>
    </div>
</@c.page>
