
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
                            <p class="card-text">${product.getPrice()}</p>
                            <a href="/productpage/addProduct/${product.getId()}" class="btn btn-primary">Buy</a>
                        </div>
                    </div>
                </td>

                        </#list>

                </#if>

            </tr>
<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--            </tr>-->
<#--            <tr>-->

<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--            </tr>-->
<#--            <tr>-->

<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--                <td>-->
<#--                    <div class="card" style="width: 18rem;">-->
<#--                        <div class="card-body">-->
<#--                            <h5 class="card-title">5</h5>-->
<#--                            <p class="card-text">It's a broader ent. This content is a little longer.</p>-->
<#--                            <a href="#" class="btn btn-primary">Buy</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </td>-->
<#--            </tr>-->
            </tbody>
        </table>
    </div>

</@c.page>
